package com.org.dao;

import com.org.po.Admin;
import com.org.po.Board;
import com.org.po.Post;
import com.org.po.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class PostDao {
    private SessionFactory sessionFactory; //通过spring注入

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*增加一个模块*/
    public boolean savePost(Post post) {
        Session session = sessionFactory.getCurrentSession();  //获得Session对象
        try {
            //System.out.println(student.getStudentName());
            session.save(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Post> findByBoard(Board board, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Post as post where post.bid = ? and post.sid=? and post.aid=?");
        query.setInteger(0, board.getId());
        query.setInteger(1, student.getId());
        query.setInteger(2, board.getAid());
        List list = query.list();                    //查询结果保存到list中
        return list;
    }

    public boolean deletePost(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Post post = (Post) session.load(Post.class, id);
            session.delete(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*更新帖子*/
    public boolean updatePost(Post post) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*通过boardId查找Post信息*/
    public List<Post> findByBoard(Board board) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Post as post where post.bid = ?");
        query.setInteger(0, board.getId());
        List list = query.list();                    //查询结果保存到list中
        return list;
    }

    /*通过PostID查找帖子的详细信息*/
    public Post getPostById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Post post = null;
        Criteria criteria = session.createCriteria(Post.class);
        criteria.add(Restrictions.eq("id", id));
        post = (Post) criteria.uniqueResult();
        return post;
    }
    /*通过Post中的sid查帖子信息*/
    public List<Post> findBySid(int sid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Post as post where post.sid = ?");
        query.setInteger(0,sid);
        List list = query.list();                    //查询结果保存到list中
        return list;
    }
}
