package com.servlet;

import com.bean.LoginBean;
import com.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        try{
            User user = loginBean.login(username, password);
            if(user != null){
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("main.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch (Exception e){
            System.out.println("登录时访问数据库失败");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
