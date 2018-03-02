package com.itdreamworks.customerdatamanage.entity.db;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    /**
     * 组织类型-系统级
     */
    public static final int ORG_SYSTEM = 0;
    /**
     * 组织类型-公司
     */
    public static final int ORG_COMPANY = 1;
    /**
     * 组织类型-企业
     */
    public static final int ORG_ENTERPRISE = 2;
    /**
     * 组织类型-客户
     */
    public static final int ORG_CUSTOMER = 3;
    /**
     * 状态-正常
     */
    public static final int STATUS_ENABLE = 1;
    /**
     * 状态-禁用
     */
    public static final int STATUS_DISABLE = 0;

    private int id, orgType, orgId, status;
    private String password, mobile, email, weiXin, qQ, realName, mark;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastLoginDatetime;

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrgType() {
        return orgType;
    }

    public void setOrgType(int orgType) {
        this.orgType = orgType;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getqQ() {
        return qQ;
    }

    public void setqQ(String qQ) {
        this.qQ = qQ;
    }

    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
