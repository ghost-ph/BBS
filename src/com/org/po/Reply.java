package com.org.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/7/4.
 */
@Entity
public class Reply {
    private int id;
    private String name;
    private String content;
    private Timestamp publishTime;
    private Integer pid;
    private Integer aid;
    private Integer sid;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "publishTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "pid", nullable = true, insertable = true, updatable = true)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "aid", nullable = true, insertable = true, updatable = true)
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "sid", nullable = true, insertable = true, updatable = true)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply reply = (Reply) o;

        if (id != reply.id) return false;
        if (aid != null ? !aid.equals(reply.aid) : reply.aid != null) return false;
        if (content != null ? !content.equals(reply.content) : reply.content != null) return false;
        if (name != null ? !name.equals(reply.name) : reply.name != null) return false;
        if (pid != null ? !pid.equals(reply.pid) : reply.pid != null) return false;
        if (publishTime != null ? !publishTime.equals(reply.publishTime) : reply.publishTime != null) return false;
        if (sid != null ? !sid.equals(reply.sid) : reply.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", pid=" + pid +
                ", aid=" + aid +
                ", sid=" + sid +
                '}';
    }
}
