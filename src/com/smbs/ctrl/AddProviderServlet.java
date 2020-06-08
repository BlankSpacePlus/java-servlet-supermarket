package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.dao.ProviderDaoImpl;
import com.smbs.entity.SuperProviders;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProviderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = sdf.format(new Date());
        SuperProviders provider = new SuperProviders();
        provider.setProviderName(request.getParameter("proName"));
        provider.setProviderDesc(request.getParameter("proDesc"));
        provider.setProviderTel(request.getParameter("phone"));
        provider.setProviderAddress(request.getParameter("address"));
        provider.setCreateTime(datetime);
        HttpSession session = request.getSession();
        SuperUsers user = (SuperUsers) session.getAttribute("user");
        String creator = user.getUserName();
        provider.setCreator(creator);
        ProviderDao providersDao = new ProviderDaoImpl();
        try {
            providersDao.addProvider(provider);
            response.sendRedirect("QueryProvidersServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
