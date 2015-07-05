package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Reply;
import com.org.po.Student;
import com.org.service.ReplyService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2015/7/4.
 */
public class ReplyAction extends ActionSupport {
    private String content;
    private int pid;

    private ReplyService replyService;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public ReplyService getReplyService() {
        return replyService;
    }

    public void setReplyService(ReplyService replyService) {
        this.replyService = replyService;
    }


    public String addReply() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Student studentInfo = (Student) session.getAttribute("studentInfo");
        pid = Integer.valueOf(request.getParameter("post.id"));
        Timestamp ts = new Timestamp(new Date().getTime());
        Reply reply = new Reply();
        reply.setPublishTime(ts);
        reply.setPid(pid);
        reply.setSid(studentInfo.getId());
        reply.setContent(request.getParameter("content"));
        if (replyService.saveReply(reply)) {
            return "success";
        } else {
            return "error";
        }
    }
}
