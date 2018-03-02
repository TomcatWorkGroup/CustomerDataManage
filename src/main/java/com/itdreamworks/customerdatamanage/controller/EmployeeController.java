package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.Employee;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.service.CustomerEmployeeService;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private CustomerEmployeeService service;

    @PostMapping(value = "/find")
    public Employee find(String loginId) throws IOException {
        return service.find(loginId);
    }

    @PostMapping(value = "/add")
    public String add(Employee employee) {
        ResultStatus status = service.add(employee);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/modify")
    public String modify(Employee employee) {
        ResultStatus status = service.modify(employee);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/remove")
    public String remove(int orgId, String loginId) {
        ResultStatus status = service.remove(orgId, loginId);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/changeStatus")
    public String changeStatus(int status, int orgId, String loginId) {
        ResultStatus s = service.changeStatus(status, orgId, loginId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/addDeviceMap")
    public String addDeviceMap(int orgId, String loginId, String productLocalId) {
        ResultStatus s = service.addDeviceMap(orgId, loginId, productLocalId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/removeDeviceMap")
    public String removeDeviceMap(int orgId, String loginId, String productLocalId) {
        ResultStatus s = service.removeDeviceMap(orgId, loginId, productLocalId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }
}
