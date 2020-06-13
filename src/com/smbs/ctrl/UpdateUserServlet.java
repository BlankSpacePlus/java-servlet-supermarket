package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.dao.UserDaoImpl;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SuperUsers superUsers=new SuperUsers();
        String id=request.getParameter("userId");
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        String phone=request.getParameter("userphone");
        String address=request.getParameter("address");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int role=Integer.parseInt(request.getParameter("auth"));
        superUsers.setUserID(id);
        superUsers.setUserName(name);
        superUsers.setPassWord(pwd);
        superUsers.setPhone(phone);
        superUsers.setAddress(address);
        superUsers.setRole(role);
        try {
            Date birthday=simpleDateFormat.parse(request.getParameter("birthday"));
            superUsers.setBirthday(birthday);
            UserDao usersDao=new UserDaoImpl();
            usersDao.updateUser(superUsers);
            response.sendRedirect("QueryUsersServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
