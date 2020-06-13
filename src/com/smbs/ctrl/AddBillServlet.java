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
        String name = request.getParameter("productName");
        int num = Integer.parseInt(request.getParameter("productNum"));
        BigDecimal price = new BigDecimal(request.getParameter("money"));
        String desc = request.getParameter("discription");
        int id2 = Integer.parseInt(request.getParameter("providerID"));
        int is=Integer.parseInt(request.getParameter("isPay"));
        HttpSession session=request.getSession();
        SuperUsers superUsers=(SuperUsers) session.getAttribute("user");
        String creator=superUsers.getUserName();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        bill.setProductName(name);
        bill.setProductCount(num);
        bill.setTotalPrice(price);
        bill.setProductDesc(desc);
        bill.setProviderID(id2);
        bill.setIsPayment(is);
        bill.setCreator(creator);
        bill.setCreateTime(datetime);
        BillDao dao = new BillDaoImpl();
        try {
            dao.addBill(bill);
            response.sendRedirect("QueryBillsServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
