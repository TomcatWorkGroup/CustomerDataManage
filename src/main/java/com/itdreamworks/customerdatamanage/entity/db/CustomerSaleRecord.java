package com.itdreamworks.customerdatamanage.entity.db;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CustomerSaleRecord implements Serializable {
    private int id,customerId;
    private String endUserLocalId;
    private String productLocalId;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date saleDatetime;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getProductLocalId() {
        return productLocalId;
    }

    public void setProductLocalId(String productLocalId) {
        this.productLocalId = productLocalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEndUserLocalId() {
        return endUserLocalId;
    }

    public void setEndUserLocalId(String endUserLocalId) {
        this.endUserLocalId = endUserLocalId;
    }

    public Date getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(Date saleDatetime) {
        this.saleDatetime = saleDatetime;
    }
}
