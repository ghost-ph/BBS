package com.org.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2015/7/4.
 */
@Entity
public class Admin {
    private int id;
    private String aoccount;
    private String password;
    private String qx;
    private String nickname;
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
    @Column(name = "aoccount", nullable = true, insertable = true, updatable = true, length = 20)
    public String getAoccount() {
        return aoccount;
    }

    public void setAoccount(String aoccount) {
        this.aoccount = aoccount;
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
    @Column(name = "qx", nullable = true, insertable = true, updatable = true, length = 20)
    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }

    @Basic
    @Column(name = "nickname", nullable = true, insertable = true, updatable = true, length = 20)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

        Admin admin = (Admin) o;

        if (id != admin.id) return false;
        if (aoccount != null ? !aoccount.equals(admin.aoccount) : admin.aoccount != null) return false;
        if (nickname != null ? !nickname.equals(admin.nickname) : admin.nickname != null) return false;
        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;
        if (phone != null ? !phone.equals(admin.phone) : admin.phone != null) return false;
        if (qx != null ? !qx.equals(admin.qx) : admin.qx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (aoccount != null ? aoccount.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (qx != null ? qx.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
