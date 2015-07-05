package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Student;
import com.org.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/4.
 */
public class RegisterAction extends ActionSupport  {
    private String msg ;
    private String account;
    private String password;
    private String role;
    private StudentService studentService;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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
    public String register(){
        HttpServletRequest request = ServletActionContext.getRequest();
       HttpSession session =request.getSession();
        account = request.getParameter("account");
        password = request.getParameter("password");
        role=request.getParameter("radiobutton");
        if (role.equals("user")){
            Student student = new Student();
            student.setNickName(account);
            student.setPassword(password);
           if (studentService.getStudentByAccount(account)==null){
               if (studentService.saveStudent(student)){//注册成功
                   session.setAttribute("studentInfo",student);
                   return "success";
               }else{

                   //TOdo 注册失败
               }
           }else{
               //TODo 用户名存在
               addActionError("用户名存在");
               msg="用户名存在";
               return  "error";
           }
        }else{
            //ToDo 管理员注册
        }
        return "success";
    }
    public boolean hasErrors(){
        return  (hasActionErrors()||hasFieldErrors());
    }
}
