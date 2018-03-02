package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.CustomerCategory;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.service.CustomerCategoryService;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CustomerCategoryService service;

    @PostMapping(value = "/add")
    public String add(CustomerCategory category) {
        ResultStatus status = service.add(category);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/remove")
    public String remove(int customerId, String localId) {
        ResultStatus status = service.remove(customerId, localId);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/changeCategoryName")
    public String changeCategoryName(String categoryName, int customerId, String localId){
        ResultStatus status = service.changeCategoryName(categoryName,customerId,localId);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }
}
