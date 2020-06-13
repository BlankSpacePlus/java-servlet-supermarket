package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserDao usersDao=new UserDaoImpl();
        try {
            usersDao.deleteUserById(request.getParameter("ID"));
            response.sendRedirect("QueryUsersServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
