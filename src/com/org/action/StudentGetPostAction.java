package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Post;
import com.org.po.Student;
import com.org.service.PostService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2015/7/5.
 */
public class StudentGetPostAction extends ActionSupport {
    private String msg;
    private List<Post> postList;
    private PostService postService;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("studentInfo");
        if (student == null) {//跳转到登录界面
            msg = "用户需要登录";
            return "error";
        }
        postList = postService.findBySid(student.getId());
        if (postList.size() == 0) msg = "没有发过帖";
        return "success";
    }
}
