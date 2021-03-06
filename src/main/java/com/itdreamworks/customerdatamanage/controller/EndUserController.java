package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.EndUser;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.service.CustomerEndUserService;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户管理 /customer
 */
@RestController
@RequestMapping("/customer")
public class EndUserController {
    @Autowired
    private CustomerEndUserService service;

    /**
     * 添加客户
     * @param endUser 客户对象
     * @return 执行结果
     */
    @PostMapping(value = "/add")
    public String add(EndUser endUser) {
        ResultStatus s = service.add(endUser);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    /**
     * 移除客户
     * @param localId 客户本地唯一标识
     * @return 执行结果
     */
    @PostMapping(value = "/remove")
    public String remove(int customerId, String localId) {
        ResultStatus s = service.remove(customerId, localId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/changeStatus")
    public String changeStatus(int status,
                               int customerId,
                               String localId) {
        ResultStatus s = service.changeStatus(status, customerId, localId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    /**
     * 修改客户信息
     * @param endUser 客户对象
     * @return 执行结果
     */
    @PostMapping(value = "/modify")
    public String modify(EndUser endUser) {
        ResultStatus s = service.modify(endUser);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }
}
