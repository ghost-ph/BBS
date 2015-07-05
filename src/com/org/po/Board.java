package com.org.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2015/7/4.
 */
@Entity
public class Board {
    private int id;
    private String name;
    private String descrption;
    private Integer parentId;
    private Integer aid;
    private String boarding;

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
    @Column(name = "descrption", nullable = true, insertable = true, updatable = true, length = 50)
    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    @Basic
    @Column(name = "parentId", nullable = true, insertable = true, updatable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
    @Column(name = "boarding", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (id != board.id) return false;
        if (aid != null ? !aid.equals(board.aid) : board.aid != null) return false;
        if (boarding != null ? !boarding.equals(board.boarding) : board.boarding != null) return false;
        if (descrption != null ? !descrption.equals(board.descrption) : board.descrption != null) return false;
        if (name != null ? !name.equals(board.name) : board.name != null) return false;
        if (parentId != null ? !parentId.equals(board.parentId) : board.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descrption != null ? descrption.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (boarding != null ? boarding.hashCode() : 0);
        return result;
    }
}
