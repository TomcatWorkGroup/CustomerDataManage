package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.Employee;
import com.itdreamworks.customerdatamanage.service.CustomerEmployeeService;
import com.itdreamworks.customerdatamanage.service.DbEntityStatus;
import com.itdreamworks.customerdatamanage.utils.DbEntityStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private CustomerEmployeeService service;

    @PostMapping(value = "/find")
    public Employee find(String loginId){
        return service.find(loginId);
    }

    @PostMapping(value = "/add")
    public String add(Employee employee){
        String str ="";
        try {
            DbEntityStatus status = service.add(employee);
            str = DbEntityStatusJsonStringUtil.getStatusString(status);
        } catch (Exception e) {
            e.printStackTrace();
            str = DbEntityStatusJsonStringUtil.getExceptionString(e);
        }
        return str;
    }

    @PostMapping(value = "/modify")
    public String modify(Employee employee){
        DbEntityStatus status = service.modify(employee);
        return DbEntityStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/remove")
    public String remove(int orgId, String loginId){
        DbEntityStatus status = service.remove(orgId,loginId);
        return DbEntityStatusJsonStringUtil.getStatusString(status);
    }

    @PostMapping(value = "/changeStatus")
    public String changeStatus(int status,int orgId,String loginId){
        DbEntityStatus s = service.changeStatus(status,orgId,loginId);
        return DbEntityStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/addDeviceMap")
    public String addDeviceMap(int orgId, String loginId,String productLocalId){
        DbEntityStatus s = service.addDeviceMap(orgId,loginId,productLocalId);
        return DbEntityStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/removeDeviceMap")
    public String removeDeviceMap(int orgId, String loginId,String productLocalId){
        DbEntityStatus s = service.removeDeviceMap(orgId,loginId,productLocalId);
        return DbEntityStatusJsonStringUtil.getStatusString(s);
    }
}
