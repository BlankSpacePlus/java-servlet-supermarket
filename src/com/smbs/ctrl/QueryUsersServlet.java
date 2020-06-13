package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.dao.UserDaoImpl;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryUsersServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserDao usersDao=new UserDaoImpl();
        try {
            List<SuperUsers> superUsersList=usersDao.getAllUsers();
            request.setAttribute("usersList",superUsersList);
            request.getRequestDispatcher("userAdmin.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
