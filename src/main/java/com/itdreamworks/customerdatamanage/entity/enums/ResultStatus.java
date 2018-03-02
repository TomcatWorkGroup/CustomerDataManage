package com.itdreamworks.customerdatamanage.entity.enums;

public enum ResultStatus {
    SOLD("已售出",0),
    DELETED("已删除",1),
    DISABLE("已禁用",2),
    UNKNOWN("未知或无该记录",10),
    UNKNOWN_CATEGORY("类别未知或无该类别",11),
    UNKNOWN_PRODUCT("产品未知或无该产品",12),
    UNKNOWN_ENDUSER("终端用户未知或无该终端用户",13),
    UNKNOWN_EMPLOYEE("员工未知或无该员工",14),
    SUCCESS("操作成功",200),
    ERROR("服务器错误",500);
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

    public static ResultStatus valueOf(int value){
        switch (value){
            case 1:
                return DELETED;
            case 2:
                return SOLD;
            default:
                return UNKNOWN;
        }
    }
}
