package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Student;
import com.org.service.StudentService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/7/4.
 */
public class LoginAction extends ActionSupport{
    private String account;
    private String password;
    private String role;
    private StudentService studentService;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session =request.getSession();
        account = request.getParameter("account");
        password = request.getParameter("password");
        role=request.getParameter("radiobutton");
        if (role.equals("user")){
            Student studentInfo =studentService.getStudent(account, password);
            if (studentInfo==null){
                return  "error";
            }else{
                session.setAttribute("studentInfo",studentInfo);
            }
        }
        return "success";
    }
}
