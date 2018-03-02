package com.itdreamworks.customerdatamanage.utils;


import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;

public class ResultStatusJsonStringUtil {
    public static String getStatusString(ResultStatus status){
        return String.format("{\"status\":%d,\"message\":\"%s\"}",status.getValue(),status.getDescription());
    }
    public static String getExceptionString(Exception ex){
        return String.format("{\"status\":%d,\"message\":\"%s\"}",
                ResultStatus.ERROR.getValue(),
                ex.getMessage());
    }
    public static String getStatusString(ResultStatus status,String msg){
        return String.format("{\"status\":%d,\"message\":\"%s\"}",
                ResultStatus.ERROR.getValue(),
                msg);
    }



}
