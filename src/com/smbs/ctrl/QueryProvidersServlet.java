package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.dao.ProviderDaoImpl;
import com.smbs.entity.SuperProviders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryProvidersServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ProviderDao dao = new ProviderDaoImpl();
        try {
            List<SuperProviders> list = dao.getAllProviders();
            request.setAttribute("providersList", list);
            request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
