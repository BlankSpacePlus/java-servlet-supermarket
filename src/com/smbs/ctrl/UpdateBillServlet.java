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

public class UpdateBillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SuperBills superBills=new SuperBills();
        int id=Integer.parseInt(request.getParameter("billNum"));
        String name=request.getParameter("productName");
        int num=Integer.parseInt(request.getParameter("productNum"));
        BigDecimal price=new BigDecimal(request.getParameter("money"));
        String desc=request.getParameter("discription");
        int id2=Integer.parseInt(request.getParameter("providerID"));
        int is=Integer.parseInt(request.getParameter("isPay"));
        HttpSession session=request.getSession();
        SuperUsers superUsers=(SuperUsers) session.getAttribute("user");
        String creator=superUsers.getUserName();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        superBills.setBillID(id);
        superBills.setProductName(name);
        superBills.setProductCount(num);
        superBills.setTotalPrice(price);
        superBills.setProductDesc(desc);
        superBills.setProviderID(id2);
        superBills.setIsPayment(is);
        superBills.setCreator(creator);
        superBills.setCreateTime(datetime);
        BillDao billsDao=new BillDaoImpl();
        try {
            billsDao.updateBill(superBills);
            response.sendRedirect("QueryBillsServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
