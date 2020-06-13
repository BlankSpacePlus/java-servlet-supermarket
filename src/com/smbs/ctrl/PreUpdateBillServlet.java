package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.dao.BillDaoImpl;
import com.smbs.dao.ProviderDao;
import com.smbs.dao.ProviderDaoImpl;
import com.smbs.entity.SuperBills;
import com.smbs.entity.SuperProviders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PreUpdateBillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BillDao billsDao=new BillDaoImpl();
        ProviderDao providersDao=new ProviderDaoImpl();
        try {
            SuperBills superBills=billsDao.getBillById(request.getParameter("ID"));
            request.setAttribute("bill",superBills);
            List<SuperProviders> superProvidersList=providersDao.getAllProviders();
            request.setAttribute("providersList",superProvidersList);
            request.getRequestDispatcher("modify.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
