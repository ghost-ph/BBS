package com.org.dao;

import com.org.po.Admin;
import com.org.po.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Administrator on 2015/7/4.
 */
public class AdminDao {
    private SessionFactory sessionFactory; //通过spring注入

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*通过账号密码查找一个用户*/
    public Admin getStudent(String account, String password){
        Session session = sessionFactory.getCurrentSession();
        Admin admin = null;
        Criteria criteria = session.createCriteria(Admin.class);
        criteria.add(Restrictions.eq("account", account));
        criteria.add(Restrictions.eq("password", password));
        admin = (Admin) criteria.uniqueResult();   //取的唯一匹配的结果，没有返回null
        return admin;
    }

    /*更新管理员信息*/
    public boolean updateStudent(Admin admin ){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(admin);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*保存一个admin信息*/
    public boolean saveAdmin(Admin admin) {
        Session session = sessionFactory.getCurrentSession();  //获得Session对象
        try {
            //System.out.println(student.getStudentName());
            session.save(admin);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

