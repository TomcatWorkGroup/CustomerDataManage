package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.CustomerCategory;
import com.itdreamworks.customerdatamanage.service.CustomerCategoryService;
import com.itdreamworks.customerdatamanage.service.DbEntityStatus;
import com.itdreamworks.customerdatamanage.utils.DbEntityStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CustomerCategoryService service;

    @PostMapping(value = "/add")
    public String add(CustomerCategory category){
        String str="";
        try {
            DbEntityStatus status = service.add(category);
            str = DbEntityStatusJsonStringUtil.getStatusString(status);
        } catch (Exception e) {
            e.printStackTrace();
            str = DbEntityStatusJsonStringUtil.getExceptionString(e);
        }
        return str;
    }

    @PostMapping(value = "/remove")
    public String remove(int customerId, String localId){
        String str="";
        try {
            DbEntityStatus status = service.remove(customerId,localId);
            str = DbEntityStatusJsonStringUtil.getStatusString(status);
        } catch (Exception e) {
            e.printStackTrace();
            str = DbEntityStatusJsonStringUtil.getExceptionString(e);
        }
        return str;
    }

    @PostMapping(value = "/changeCategoryName")
    public String changeCategoryName(String categoryName, int customerId, String localId){
        DbEntityStatus status = service.changeCategoryName(categoryName,customerId,localId);
        return DbEntityStatusJsonStringUtil.getStatusString(status);
    }
}
