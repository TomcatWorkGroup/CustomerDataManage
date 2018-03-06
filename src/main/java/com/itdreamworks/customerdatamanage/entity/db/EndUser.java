package com.itdreamworks.customerdatamanage.entity.db;

import java.io.Serializable;

/**
 * 客户entity
 */
public class EndUser implements Serializable {
    private  int id,enterpriseId,customerId,status;
    private  String endUserName;

    /**
     * 获取本地唯一标识
     * @return 本地唯一标识
     */
    public String getLocalId() {
        return LocalId;
    }

    /**
     * 设置本地唯一标识
     * @param localId 本地唯一标识
     */
    public void setLocalId(String localId) {
        LocalId = localId;
    }

    private String LocalId;
    private String contacts;
    private String telephone;
    private String province;
    private String city;

    /**
     * 获取联系人
     * @return 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取联系电话
     * @return 联系电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置联系电话
     * @param telephone 联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取省份
     * @return 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     * @param province 身份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     * @return 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取地址
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取状态 0禁用 1正常
     * @return 状态
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置状态（暂时无用，请始终设置为1）
     * @param status 0禁用 1正常
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 获取客户名称
     * @return 客户名称
     */
    public String getEndUserName() {
        return endUserName;
    }

    /**
     * 设置客户名称
     * @param endUserName 客户名称
     */
    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
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
}
