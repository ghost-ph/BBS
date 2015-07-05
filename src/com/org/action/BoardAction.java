package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Board;
import com.org.po.Post;
import com.org.po.Student;
import com.org.service.BoardService;
import com.org.service.PostService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class BoardAction extends ActionSupport {

    private Student student;
    private List<Post> postList;
    private List<Board> boardList;
    private BoardService boardService;
    private PostService postService;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }


    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public BoardService getBoardService() {
        return boardService;
    }

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }


    public String BoardList() {//查看全部的模块
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("studentInfo");
        if (student == null) {
            //TODO 明天写注册界面
            request.setAttribute("msg","<a href=\"login.jsp\" target=\"_blank\">登录</a>/<a href=\"register.jsp\" target=\"_blank\">注册</a>\n");
        } else {
            request.setAttribute("msg","<a href=..\\student_info.jsp>"+student.getNickName()+"</a>");
        }
        boardList = boardService.getAllBoards();
        for (Board board : boardList) {
            postList = postService.findAllPosts(board);
        }
        return "success";
    }
}
