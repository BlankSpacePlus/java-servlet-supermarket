package com.smbs.dao;

import com.smbs.entity.SuperBills;

import java.util.List;

public interface BillDao {

    List<SuperBills> getAllBills();

    SuperBills getBillById(String id);

    boolean updateBill(SuperBills bill);

    boolean deleteBill(int id);

    boolean addBill(SuperBills bill);

    List<SuperBills> search(String search_name, int isPayment);

}
