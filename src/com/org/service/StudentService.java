package com.org.service;

import com.org.dao.PostDao;
import com.org.dao.StudentDao;
import com.org.po.Board;
import com.org.po.Post;
import com.org.po.Student;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class StudentService {
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public Student getStudent(String account, String password) {
        return studentDao.getStudent(account, password);
    }

    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }
    public Student getStudentByAccount(String account) {
        return studentDao.getStudentByAccount(account);
    }
}
