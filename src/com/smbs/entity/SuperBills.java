package com.smbs.entity;

import java.math.BigDecimal;

public class SuperBills {

    private int billID;

    private String productName;

    private String productDesc;

    private int productCount;

    private BigDecimal totalPrice;

    private int isPayment;

    private int providerID;

    private String creator;

    private String createTime;

    public SuperBills() {}

    public SuperBills(int billID, String productName, String productDesc, int productCount, BigDecimal totalPrice,
                      int isPayment, int providerID, String creator, String createTime) {
        this.billID = billID;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.providerID = providerID;
        this.creator = creator;
        this.createTime = createTime;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
