package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.EndUser;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.service.CustomerEndUserService;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
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
    public String add(EndUser endUser) {
        ResultStatus s = service.add(endUser);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

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

    @PostMapping(value = "/modify")
    public String modify(EndUser endUser) {
        ResultStatus s = service.modify(endUser);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }
}
