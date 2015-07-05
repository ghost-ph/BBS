package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Post;
import com.org.po.Student;
import com.org.service.PostService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/7/4.
 */
public class AddPostAction extends ActionSupport {
    private String name;
    private String content;
    private int bid;
    private PostService postService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public String addPost() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        name=request.getParameter("name");
        content=request.getParameter("content");
        bid =Integer.valueOf(request.getParameter("home"));
        Student studentInfo= (Student) session.getAttribute("studentInfo");
        /*获取当前的时间*/
        Timestamp ts = new Timestamp(new Date().getTime());
        Post post = new Post();
        post.setBid(bid);
        post.setContent(content);
        post.setName(name);
        post.setSid(studentInfo.getId());
        post.setPublishTime(ts);
        if(postService.savePost(post)){
            return  "success";
        }
        return "error";
    }
}
