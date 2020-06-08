package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.dao.UserDaoImpl;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        UserDao dao = new UserDaoImpl();
        try {
            SuperUsers user = dao.getUserByName(username);
            if (user != null && user.getPassWord() != null && user.getPassWord().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("admin_index.html");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
