package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.EndUser;
import com.itdreamworks.customerdatamanage.service.CustomerEndUserService;
import com.itdreamworks.customerdatamanage.service.DbEntityStatus;
import com.itdreamworks.customerdatamanage.utils.DbEntityStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class EndUserController {
    @Autowired
    private CustomerEndUserService service;

    @PostMapping(value = "/add")
    public String add(EndUser endUser){
        String str ="";
        try {
            DbEntityStatus s = service.add(endUser);
            str = DbEntityStatusJsonStringUtil.getStatusString(s);
        } catch (Exception e) {
            e.printStackTrace();
            str = DbEntityStatusJsonStringUtil.getExceptionString(e);
        }
        return str;
    }

    @PostMapping(value = "/remove")
    public String remove(int customerId,String localId){
        DbEntityStatus s = service.remove(customerId,localId);
        return DbEntityStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/changeStatus")
    public String changeStatus(int status,
                               int customerId,
                               String localId){
        DbEntityStatus s = service.changeStatus(status,customerId,localId);
        return DbEntityStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/modify")
    public String modify(EndUser endUser){
        String str ="";
        try {
            DbEntityStatus s = service.modify(endUser);
            str = DbEntityStatusJsonStringUtil.getStatusString(s);
        } catch (Exception e) {
            e.printStackTrace();
            str = DbEntityStatusJsonStringUtil.getExceptionString(e);
        }
        return str;
    }
}
