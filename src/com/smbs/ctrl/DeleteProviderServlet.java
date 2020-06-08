package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.dao.ProviderDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProviderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("providerID");
        ProviderDao dao = new ProviderDaoImpl();
        try {
            dao.deleteProviderById(id);
            response.sendRedirect("QueryProvidersServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
