package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.dao.UserDaoImpl;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SuperUsers superUsers=new SuperUsers();
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("auth");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        superUsers.setUserName(request.getParameter("username"));
        superUsers.setPassWord(request.getParameter("password"));
        superUsers.setPhone(request.getParameter("userphone"));
        superUsers.setAddress(request.getParameter("address"));
        superUsers.setRole(Integer.parseInt(name));
        superUsers.setUserID(name);
        try {
            Date birthday=simpleDateFormat.parse(request.getParameter("birthday"));
            superUsers.setBirthday(birthday);
            UserDao usersDao=new UserDaoImpl();
            usersDao.addUser(superUsers);
            response.sendRedirect("QueryUsersServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
