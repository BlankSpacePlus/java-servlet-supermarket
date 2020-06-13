package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.dao.UserDaoImpl;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreUpdateUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserDao dao=new UserDaoImpl();
        try {
            SuperUsers superUsers=dao.getUserById(request.getParameter("ID"));
            request.setAttribute("user", superUsers);
            request.getRequestDispatcher("modifyUsers.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
