package com.itdreamworks.customerdatamanage.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class EnterpriseSaleRecord implements Serializable {
    private int id, enterpriseId,customerId,endUserId;
    private String enterpriseProductCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date saleDatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnterpriseProductCode() {
        return enterpriseProductCode;
    }

    public void setEnterpriseProductCode(String enterpriseProductCode) {
        this.enterpriseProductCode = enterpriseProductCode;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }

    public Date getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(Date saleDatetime) {
        this.saleDatetime = saleDatetime;
    }
}
