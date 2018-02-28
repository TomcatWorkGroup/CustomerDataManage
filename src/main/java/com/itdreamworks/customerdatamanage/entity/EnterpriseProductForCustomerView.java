package com.itdreamworks.customerdatamanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class EnterpriseProductForCustomerView implements Serializable {
    private String enterpriseName;

    private String categoryName;

    /**
     * 企业将产品销售给客户时将客户ID填入此列
     */
    private Integer customerId;

    private String productCode;

    private Date SaleDatetime;

    private static final long serialVersionUID = 1L;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getSaleDatetime() {
        return SaleDatetime;
    }

    public void setSaleDatetime(Date saleDatetime) {
        this.SaleDatetime = saleDatetime;
    }

}