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

/**
 * 产品类别管理 /category
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CustomerCategoryService service;

    /**
     * 添加产品类别
     * @param category 产品类别对象
     * @return 执行结果
     */
    @PostMapping(value = "/add")
    public String add(CustomerCategory category) {
        ResultStatus status = service.add(category);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    /**
     * 移除产品类别
     * @param localId 本地产品类别唯一标识
     * @return 执行结果
     */
    @PostMapping(value = "/remove")
    public String remove(int customerId, String localId) {
        ResultStatus status = service.remove(customerId, localId);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    /**
     * 修改产品类别名称
     * @param categoryName 新产品类别名称
     * @param localId 本地产品类别唯一标识
     * @return 执行结果
     */
    @PostMapping(value = "/changeCategoryName")
    public String changeCategoryName(String categoryName, int customerId, String localId){
        ResultStatus status = service.changeCategoryName(categoryName,customerId,localId);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }
}
