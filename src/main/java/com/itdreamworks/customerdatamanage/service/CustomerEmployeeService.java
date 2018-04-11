package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.db.CustomerProduct;
import com.itdreamworks.customerdatamanage.entity.db.Employee;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.mapper2.CustomerDeviceEmployeeMapMapper2;
import com.itdreamworks.customerdatamanage.mapper2.CustomerEmployeeMapper2;
import com.itdreamworks.customerdatamanage.mapper2.CustomerProductMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerEmployeeService {
    @Autowired
    private CustomerEmployeeMapper2 employeeDao;
    @Autowired
    private CustomerDeviceEmployeeMapMapper2 deMapDao;
    @Autowired
    private CustomerProductMapper2 productDao;

    public Employee find(String loginId){
        return employeeDao.findByLoginId(loginId);
    }

    @Transactional
    public ResultStatus remove(int orgId, String loginId){
        Employee employee = employeeDao.find(orgId,loginId);
        if(null == employee)
            return ResultStatus.UNKNOWN_EMPLOYEE;

        deMapDao.removeEmployeeMap(employee.getId());
        employeeDao.remove(orgId,loginId);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus modify(Employee employee){
        int i = employeeDao.modify(employee);
        if(1 == i)
            return ResultStatus.SUCCESS;
        else
            return ResultStatus.UNKNOWN_EMPLOYEE;
    }

    public ResultStatus changeStatus(int status,int orgId,String loginId){
        int i = employeeDao.changeStatus(status,orgId,loginId);
        if(1 == i)
            return ResultStatus.SUCCESS;
        else
            return ResultStatus.UNKNOWN_EMPLOYEE;
    }

    public ResultStatus add(int orgId,Employee employee){
        employee.setOrgType(Employee.ORG_CUSTOMER);
        employee.setOrgId(orgId);
        employeeDao.add(employee);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus addDeviceMap(int orgId, String loginId,String productLocalId){
        Employee employee = employeeDao.find(orgId,loginId);
        if(null == employee){
            return ResultStatus.UNKNOWN_EMPLOYEE;
        }
        if(Employee.STATUS_DISABLE == employee.getStatus()){
            return ResultStatus.DISABLE_EMPLOYEE;
        }
        CustomerProduct product = productDao.find(orgId,productLocalId);
        if(null == product)
            return ResultStatus.UNKNOWN_PRODUCT;

        if(deMapDao.checkExists(employee.getId(),product.getDeviceId())>0)
            return ResultStatus.SUCCESS;

        deMapDao.add(employee.getId(),product.getDeviceId());
        return ResultStatus.SUCCESS;
    }

    public ResultStatus removeDeviceMap(int orgId, String loginId,String productLocalId){
        Employee employee = employeeDao.find(orgId,loginId);
        if(null == employee)
            return ResultStatus.UNKNOWN_EMPLOYEE;

        CustomerProduct product = productDao.find(orgId,productLocalId);
        if(null == product)
            return ResultStatus.UNKNOWN_PRODUCT;

        deMapDao.remove(employee.getId(),product.getDeviceId());
        return ResultStatus.SUCCESS;
    }
}
