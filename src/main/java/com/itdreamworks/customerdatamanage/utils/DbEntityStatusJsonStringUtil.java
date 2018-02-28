package com.itdreamworks.customerdatamanage.utils;

import com.itdreamworks.customerdatamanage.service.DbEntityStatus;

public class DbEntityStatusJsonStringUtil {
    public static String getStatusString(DbEntityStatus status){
        return String.format("{\"code\":%d,\"msg\":\"%s\"}",status.getValue(),status.getDescription());
    }
    public static String getExceptionString(Exception ex){
        return String.format("{\"code\":%d,\"msg\":\"%s\"}",
                DbEntityStatus.ERROR.getValue(),
                ex.getMessage());
    }

}
