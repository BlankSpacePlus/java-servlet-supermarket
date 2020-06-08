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

public class UpdateProviderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HttpSession session = request.getSession();
        SuperUsers user = (SuperUsers) session.getAttribute("user");
        SuperProviders superProviders=new SuperProviders(Integer.parseInt(request.getParameter("proId")),
                request.getParameter("proName"), request.getParameter("proDesc"), request.getParameter("phone"),
                request.getParameter("address"), sdf.format(new Date()), user.getUserName());
        ProviderDao dao = new ProviderDaoImpl();
        try {
            dao.updateProvider(superProviders);
            response.sendRedirect("QueryProvidersServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
