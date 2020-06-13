package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.dao.BillDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("ID"));
        BillDao billsDao=new BillDaoImpl();
        try {
            billsDao.deleteBill(id);
            response.sendRedirect("QueryBillsServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
