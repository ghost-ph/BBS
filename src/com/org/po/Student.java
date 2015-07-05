package com.org.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2015/7/4.
 */
@Entity
public class Student {
    private int id;
    private String nickName;
    private String password;
    private String qq;
    private String realname;
    private String phone;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickName", nullable = true, insertable = true, updatable = true, length = 20)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "qq", nullable = true, insertable = true, updatable = true, length = 20)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "realname", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (nickName != null ? !nickName.equals(student.nickName) : student.nickName != null) return false;
        if (password != null ? !password.equals(student.password) : student.password != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (qq != null ? !qq.equals(student.qq) : student.qq != null) return false;
        if (realname != null ? !realname.equals(student.realname) : student.realname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", qq='" + qq + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
