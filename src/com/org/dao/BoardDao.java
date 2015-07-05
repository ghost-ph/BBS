package com.org.dao;

import com.org.po.Board;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class BoardDao {
    private SessionFactory sessionFactory; //通过spring注入

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    /*增加一个模块*/
    public boolean saveBoard(Board board) {
        Session session = sessionFactory.getCurrentSession();  //获得Session对象
        try {
            //System.out.println(student.getStudentName());
            session.save(board);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /*查询所有board中的信息*/
    public List<Board> getAllBoards() {
        Session session = sessionFactory.getCurrentSession();//获得Session对象
        Query query = session.createQuery("from Board ");
        List list = query.list();		    //查询结果保存到list中
        return list;
    }
}
