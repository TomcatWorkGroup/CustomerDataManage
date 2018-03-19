package com.itdreamworks.customerdatamanage.entity.db;

import java.io.Serializable;

/**
 * 产品entity
 */
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

    /**
     * 获取产品本地唯一标识
     * @return 产品本地唯一标识
     */
    public String getLocalId() {
        return localId;
    }

    /**
     * 设置产品本地唯一标识
     * @param localId 产品本地唯一标识
     */
    public void setLocalId(String localId) {
        this.localId = localId;
    }

    /**
     * 获取产品类别本地唯一标识
     * @return 品类别本地唯一标识
     */
    public String getCategoryLocalId() {
        return categoryLocalId;
    }

    /**
     * 设置品类别本地唯一标识
     * @param categoryLocalId 品类别本地唯一标识
     */
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

    /**
     * 获取产品销售状态
     * @return 产品销售状态 0已售 1待售
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置产品销售状态
     * @param status 产品销售状态 0已售 1待售
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取产品关联的配件编号
     * @return 配件编号
     */
    public String getEnterpriseProductCode() {
        return enterpriseProductCode;
    }

    /**
     * 设置产品关联的配件编号
     * @param enterpriseProductCode 配件编号
     */
    public void setEnterpriseProductCode(String enterpriseProductCode) {
        this.enterpriseProductCode = enterpriseProductCode;
    }

    /**
     * 获取产品编码
     * @return 产品编码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置产品编码
     * @param productCode 产品编码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
