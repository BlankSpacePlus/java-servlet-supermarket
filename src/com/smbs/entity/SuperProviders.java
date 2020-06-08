package com.smbs.entity;

public class SuperProviders {

    private int providerID;

    private String providerName;

    private String providerDesc;

    private String providerTel;

    private String providerAddress;

    private String creator;

    private String createTime;

    public SuperProviders() {}

    public SuperProviders(int providerID, String providerName, String providerDesc, String providerTel,
                          String providerAddress, String creator, String createTime) {
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerDesc = providerDesc;
        this.providerTel = providerTel;
        this.providerAddress = providerAddress;
        this.creator = creator;
        this.createTime = createTime;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDesc() {
        return providerDesc;
    }

    public void setProviderDesc(String providerDesc) {
        this.providerDesc = providerDesc;
    }

    public String getProviderTel() {
        return providerTel;
    }

    public void setProviderTel(String providerTel) {
        this.providerTel = providerTel;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
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
