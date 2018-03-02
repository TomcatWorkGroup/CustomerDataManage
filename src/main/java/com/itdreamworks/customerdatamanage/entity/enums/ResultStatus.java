package com.itdreamworks.customerdatamanage.entity.enums;

public enum ResultStatus {
    SUCCESS("操作成功",0),
    UNKNOWN_CATEGORY("类别未知或无该类别",100),
    UNKNOWN_PRODUCT("产品未知或无该产品",101),
    UNKNOWN_ENDUSER("终端用户未知或无该终端用户",102),
    UNKNOWN_EMPLOYEE("员工未知或无该员工",103),
    UNKNOWN_ENTERPRISE_PRODUCT("配件未知或无该配件",104),
    DISABLE_EMPLOYEE("员工被禁用",200),
    SOLD_PRODUCT("产品已售出",300),
    ERROR("异常",400);

    private String description;
    private int index;
    private ResultStatus(String description,int index){
        this.description = description;
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public int getValue(){
        return this.index;
    }
}
