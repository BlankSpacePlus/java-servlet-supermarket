package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.dao.BillDaoImpl;
import com.smbs.entity.SuperBills;
import com.smbs.entity.SuperUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddBillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SuperBills bill = new SuperBills();
        HttpSession session=request.getSession();
        SuperUsers superUsers=(SuperUsers) session.getAttribute("user");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        bill.setProductName(request.getParameter("productName"));
        bill.setProductCount(Integer.parseInt(request.getParameter("productNum")));
        bill.setTotalPrice(new BigDecimal(request.getParameter("money")));
        bill.setProductDesc(request.getParameter("discription"));
        bill.setProviderID(Integer.parseInt(request.getParameter("providerID")));
        bill.setIsPayment(Integer.parseInt(request.getParameter("isPay")));
        bill.setCreator(superUsers.getUserName());
        bill.setCreateTime(df.format(new Date()));
        BillDao dao = new BillDaoImpl();
        try {
            dao.addBill(bill);
            response.sendRedirect("QueryBillsServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
