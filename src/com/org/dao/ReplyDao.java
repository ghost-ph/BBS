package com.org.dao;

import com.org.po.Board;
import com.org.po.Post;
import com.org.po.Reply;
import com.org.po.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class ReplyDao {
    private SessionFactory sessionFactory; //通过spring注入

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*增加一个模块*/
    public boolean saveReply(Reply reply) {
        Session session = sessionFactory.getCurrentSession();  //获得Session对象
        try {
            //System.out.println(student.getStudentName());
            session.save(reply);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Reply> findByPost(Post post) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Reply as reply where reply.pid = ?");
        query.setInteger(0, post.getId());
        List list = query.list();                    //查询结果保存到list中
        return list;
    }
    /*通过pid删除这个帖子的回复*/
    public boolean deleteReply(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Reply reply = (Reply) session.load(Reply.class, id);
            session.delete(reply);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
