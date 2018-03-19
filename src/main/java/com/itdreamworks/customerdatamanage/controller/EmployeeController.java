package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.Employee;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.service.CustomerEmployeeService;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 员工管理 /employee
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private CustomerEmployeeService service;

    @PostMapping(value = "/find")
    public Employee find(String loginId) throws IOException {
        return service.find(loginId);
    }

    /**
     * 添加员工
     * @param employee 员工对象
     * @return 执行结果
     */
    @PostMapping(value = "/add")
    public String add(Employee employee) {
        ResultStatus status = service.add(employee);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    /**
     * 修改员工基本信息
     * @param employee 员工对象
     * @return 执行结果
     */
    @PostMapping(value = "/modify")
    public String modify(Employee employee) {
        ResultStatus status = service.modify(employee);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    /**
     * 移除员工，员工在移除后其关联的数据将一并移除
     * @param loginId 登录账号
     * @return 执行结果
     */
    @PostMapping(value = "/remove")
    public String remove(@RequestParam("customerId") int orgId, String loginId) {
        ResultStatus status = service.remove(orgId, loginId);
        return ResultStatusJsonStringUtil.getStatusString(status);
    }

    /**
     * 修改员工状态
     * @param status 状态 0禁用 1正常
     * @param loginId 登录账号
     * @return 执行结果
     */
    @PostMapping(value = "/changeStatus")
    public String changeStatus(int status, @RequestParam("customerId") int orgId, String loginId) {
        ResultStatus s = service.changeStatus(status, orgId, loginId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    /**
     * 添加员工与产品映射关系
     * @param loginId 员工登录账号
     * @param productLocalId 产品本地唯一标识
     * @return 执行结果
     */
    @PostMapping(value = "/addDeviceMap")
    public String addDeviceMap(@RequestParam("customerId") int orgId, String loginId, String productLocalId) {
        ResultStatus s = service.addDeviceMap(orgId, loginId, productLocalId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    /**
     * 移除员工与产品映射关系
     * @param loginId 员工登录账号
     * @param productLocalId 产品本地唯一标识
     * @return 执行结果
     */
    @PostMapping(value = "/removeDeviceMap")
    public String removeDeviceMap(@RequestParam("customerId") int orgId, String loginId, String productLocalId) {
        ResultStatus s = service.removeDeviceMap(orgId, loginId, productLocalId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }
}
