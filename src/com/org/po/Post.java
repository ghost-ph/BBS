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
public class Post {
    private int id;
    private String name;
    private String content;
    private Timestamp publishTime;
    private Integer sid;
    private Integer aid;
    private Integer bid;
    private Integer count;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 20)
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
    @Column(name = "sid", nullable = true, insertable = true, updatable = true)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
    @Column(name = "bid", nullable = true, insertable = true, updatable = true)
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "count", nullable = true, insertable = true, updatable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != post.id) return false;
        if (aid != null ? !aid.equals(post.aid) : post.aid != null) return false;
        if (bid != null ? !bid.equals(post.bid) : post.bid != null) return false;
        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        if (count != null ? !count.equals(post.count) : post.count != null) return false;
        if (name != null ? !name.equals(post.name) : post.name != null) return false;
        if (publishTime != null ? !publishTime.equals(post.publishTime) : post.publishTime != null) return false;
        if (sid != null ? !sid.equals(post.sid) : post.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (bid != null ? bid.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", sid=" + sid +
                ", aid=" + aid +
                ", bid=" + bid +
                ", count=" + count +
                '}';
    }
}
