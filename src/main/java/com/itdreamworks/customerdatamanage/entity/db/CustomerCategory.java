package com.itdreamworks.customerdatamanage.entity.db;

import java.io.Serializable;

/**
 * 产品类别Entity
 */
public class CustomerCategory implements Serializable {
    private  int id,customerId;
    private String categoryName;
    private String localId;

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
     * 获取产品类别本地唯一标识
     * @return 产品类别本地唯一标识
     */
    public String getLocalId() {
        return localId;
    }

    /**
     * 设置产品类别本地唯一标识
     * @param localId 产品类别本地唯一标识
     */
    public void setLocalId(String localId) {
        this.localId = localId;
    }

    /**
     * 获取产品类别名称
     * @return 产品类别名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置产品类别名称
     * @param categoryName 产品类别名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
