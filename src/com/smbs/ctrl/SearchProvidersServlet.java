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

public class SearchProvidersServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("providerName");
        String desc=request.getParameter("providerDesc");
        ProviderDao providersDao=new ProviderDaoImpl();
        try {
            List<SuperProviders> superProvidersList=providersDao.search(name,desc);
            request.setAttribute("providersList",superProvidersList);
            request.getRequestDispatcher("providerAdmin.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
