package com.org.dao;


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
public class StudentDao {
    private SessionFactory sessionFactory; //通过spring注入

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*保存一个用户信息*/
    public boolean saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();  //获得Session对象
        try {
            //System.out.println(student.getStudentName());
            session.save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*更新一个用户信息*/
    public boolean updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Student> getStudent() {
        Session session = sessionFactory.getCurrentSession();//获得Session对象
        Query query = session.createQuery("from Student ");
        List list = query.list();                    //查询结果保存到list中
        return list;
    }

    /*通过Sid查出Student*/
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = null;
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("id", id));
        student = (Student) criteria.uniqueResult();
        return student;
    }
    /*通过账号和密码查出是否有这个用户*/
    public Student getStudent(String account, String password) {
        Session session = sessionFactory.getCurrentSession();
        Student student = null;
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("nickName", account));
        criteria.add(Restrictions.eq("password", password));
        student = (Student) criteria.uniqueResult();
        return student;
    }
    /*账号唯一 允许用户注册*/
    public Student getStudentByAccount(String account) {
        Session session = sessionFactory.getCurrentSession();
        Student student = null;
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("nickName", account));
        student = (Student) criteria.uniqueResult();
        return student;
    }
}