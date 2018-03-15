package com.test.servlet;

import com.test.entity.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
      this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UserService userService = new UserServiceImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User user1 = userService.login(user);


        System.out.println(user1.getId());
        System.out.println(user1.getUsername());
        System.out.println(user1.getPassword());

        if(user1.getUsername() != null && user1.getPassword() != null){
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
    }

}
