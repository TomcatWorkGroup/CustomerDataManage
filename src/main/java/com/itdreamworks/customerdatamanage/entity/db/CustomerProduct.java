package com.itdreamworks.customerdatamanage.entity.db;

import java.io.Serializable;

public class CustomerProduct implements Serializable {
    /**
     * Status 已销售
     */
    public static final int  STATUS_SOLD = 0;
    private  int id,customerId,deviceId,status;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    private int enterpriseId;
    private String enterpriseProductCode;
    private String productCode,localId,categoryLocalId;

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getCategoryLocalId() {
        return categoryLocalId;
    }

    public void setCategoryLocalId(String categoryLocalId) {
        this.categoryLocalId = categoryLocalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getEnterpriseProductCode() {
        return enterpriseProductCode;
    }

    public void setEnterpriseProductCode(String enterpriseProductCode) {
        this.enterpriseProductCode = enterpriseProductCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
