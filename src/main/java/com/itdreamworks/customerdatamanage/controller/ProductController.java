package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.CustomerProduct;
import com.itdreamworks.customerdatamanage.service.CustomerProductService;
import com.itdreamworks.customerdatamanage.service.DbEntityStatus;
import com.itdreamworks.customerdatamanage.utils.DbEntityStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private CustomerProductService service;

    @PostMapping(value = "/add")
    public String  add(CustomerProduct product){
        String str="";
        try {
            DbEntityStatus status = service.add(product);
            str = DbEntityStatusJsonStringUtil.getStatusString(status);
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

    @PostMapping(value = "/modify")
    public String modify(CustomerProduct product){
        DbEntityStatus s = service.modify(product);
        return DbEntityStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/sell")
    public String sell(int customerId, String productLocalId, String endUserLocalId, String saleDatetime){
        String str= "";
        try {
            Date date = format.parse(saleDatetime);
            DbEntityStatus s = service.sell(customerId,productLocalId,endUserLocalId,date);
            return DbEntityStatusJsonStringUtil.getStatusString(s);
        } catch (Exception e) {
            e.printStackTrace();
            return DbEntityStatusJsonStringUtil.getExceptionString(e);
        }
    }
}
