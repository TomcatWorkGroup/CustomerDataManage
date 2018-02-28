package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.CustomerProduct;
import com.itdreamworks.customerdatamanage.entity.Employee;
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
    public DbEntityStatus remove(int orgId, String loginId){
        Employee employee = employeeDao.find(orgId,loginId);
        if(null == employee)
            return DbEntityStatus.UNKNOWN;

        deMapDao.removeEmployeeMap(employee.getId());
        employeeDao.remove(orgId,loginId);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus modify(Employee employee){
        int i = employeeDao.modify(employee);
        if(1 == i)
            return DbEntityStatus.SUCCESS;
        else
            return DbEntityStatus.DELETED;
    }

    public DbEntityStatus changeStatus(int status,int orgId,String loginId){
        employeeDao.changeStatus(status,orgId,loginId);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus add(Employee employee) throws Exception{
        employee.setOrgType(Employee.ORG_CUSTOMER);
        employeeDao.add(employee);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus addDeviceMap(int orgId, String loginId,String productLocalId){
        Employee employee = employeeDao.find(orgId,loginId);
        if(null == employee){
            return DbEntityStatus.UNKNOWN_EMPLOYEE;
        }
        if(Employee.STATUS_DISABLE == employee.getStatus()){
            return DbEntityStatus.DISABLE;
        }
        CustomerProduct product = productDao.find(orgId,productLocalId);
        if(null == product)
            return DbEntityStatus.UNKNOWN_PRODUCT;

        if(deMapDao.checkExists(employee.getId(),product.getDeviceId())>0)
            return DbEntityStatus.SUCCESS;

        deMapDao.add(employee.getId(),product.getDeviceId());
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus removeDeviceMap(int orgId, String loginId,String productLocalId){
        Employee employee = employeeDao.find(orgId,loginId);
        if(null == employee)
            return DbEntityStatus.UNKNOWN_EMPLOYEE;

        CustomerProduct product = productDao.find(orgId,productLocalId);
        if(null == product)
            return DbEntityStatus.UNKNOWN_PRODUCT;

        deMapDao.remove(employee.getId(),product.getDeviceId());
        return DbEntityStatus.SUCCESS;
    }
}
