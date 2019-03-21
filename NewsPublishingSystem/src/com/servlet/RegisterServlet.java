package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bean.RegisterBean;
import com.vo.User;

//@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public RegisterServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            String sex = request.getParameter("sex");
            String profession = request.getParameter("profession");
            String[] temp = request.getParameterValues("favourite");
            String favourite = "";
            if(temp != null){
                for(int i = 0; i < temp.length; i++){
                    if(i == 0){
                        favourite = temp[0];
                    }else{
                        favourite += "," + temp[i];
                    }
                }
            }
            String note = request.getParameter("note");

            //将用户信息存放在User中
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setSex(sex);
            user.setProfession(profession);
            user.setFavourite(favourite);
            user.setNote(note);

            List<String> errorList = new ArrayList<>();
            RegisterBean registerBean = new RegisterBean();
            boolean flag = registerBean.checkRepeatUsername(user);
            if(!flag){
                errorList.add("用户名重复");
            }
            if(username.equals("") || username.charAt(0) == ' '){
                errorList.add("用户名不能为空!");
            }
            if(password == null || password.length() < 6 || password.length() > 18){
                errorList.add("密码必须在6到18位之间!");
            }
            if(repassword == null || repassword.length() < 6 || repassword.length() > 18){
                errorList.add("确认密码必须在6到18位之间!");
            }
            if(password != null && repassword != null && !password.equals(repassword)){
                errorList.add("密码和确认密码必须相等");
            }
            request.setAttribute("errorList", errorList);
            if(errorList.isEmpty()){
                registerBean.registerUser(user);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
