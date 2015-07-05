package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Post;
import com.org.po.Reply;
import com.org.po.Student;
import com.org.service.PostService;
import com.org.service.ReplyService;
import com.org.service.StudentService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class PostShowAction extends ActionSupport {
    private Student student;
    private StudentService studentService;
    private PostService postService;
    private ReplyService replyService;
    private Post post;
    private List<Reply> ReplyList;


    private List<Student> studentList = new ArrayList<Student>();
    

    public ReplyService getReplyService() {
        return replyService;
    }

    public void setReplyService(ReplyService replyService) {
        this.replyService = replyService;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Reply> getReplyList() {
        return ReplyList;
    }

    public void setReplyList(List<Reply> replyList) {
        ReplyList = replyList;
    }

    public String getPostInfo() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String pid = request.getParameter("post.id");
        post = postService.getPostById(Integer.valueOf(pid));
        if (post != null) {
            session.setAttribute("post", post);
        } else {
            post = (Post) session.getAttribute("post");
        }
        int sid = post.getSid();
        student = studentService.getStudentById(sid);
        if (student != null) {
            ReplyList = replyService.findByPost(post);
            for (Reply reply : ReplyList) {
                Student student1 =studentService.getStudentById(reply.getSid());
                studentList.add(student1);
                request.setAttribute("studentList",studentList);
            }
            return "success";
        }

        return "error";
    }
}
