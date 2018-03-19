package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.db.*;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.mapper2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CustomerProductService {
    @Autowired
    private CustomerProductMapper2 productDao;
    @Autowired
    private CustomerEndUserMapper2 endUserDao;
    @Autowired
    private CustomerSaleRecordMapper2 saleRecordDao;
    @Autowired
    private CustomerCategoryMapper2 categoryDao;
    @Autowired
    private DeviceMapper2 deviceDao;
    @Autowired
    private EnterpriseSaleRecordForCustomerMapper2 enterpriseSaleRecordForCustomerDao;
    @Autowired
    private EnterpriseProductForCustomer2 enterpriseProductForCustomerDao;

    public ResultStatus add(CustomerProduct product){
        EnterpriseProduct enterpriseProduct = enterpriseProductForCustomerDao.getProduct(product.getEnterpriseProductCode());
        if(null == enterpriseProduct)
            return ResultStatus.UNKNOWN_PRODUCT;

        CustomerCategory category = categoryDao.find(product.getCustomerId(),product.getCategoryLocalId());
        if(null == category)
            return ResultStatus.UNKNOWN_CATEGORY;

        //补全关联信息
        product.setDeviceId(enterpriseProduct.getDeviceId());
        product.setEnterpriseId(enterpriseProduct.getEnterpriseId());
        productDao.add(product);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus remove(int customerId,String localId){
        CustomerProduct product = productDao.find(customerId,localId);
        if(null == product){
            return ResultStatus.UNKNOWN_PRODUCT;
        }else if(product.getStatus() == CustomerProduct.STATUS_SOLD){
            return ResultStatus.SOLD_PRODUCT;
        }else {
            productDao.remove(customerId,localId);
            return ResultStatus.SUCCESS;
        }
    }

    public ResultStatus modify(CustomerProduct product){
        EnterpriseProduct enterpriseProduct = enterpriseProductForCustomerDao.getProduct(product.getEnterpriseProductCode());
        if(null == enterpriseProduct)
            return ResultStatus.UNKNOWN_ENTERPRISE_PRODUCT;

        CustomerCategory category = categoryDao.find(product.getCustomerId(),product.getCategoryLocalId());
        if(null == category)
            return ResultStatus.UNKNOWN_CATEGORY;

        //补全关联信息
        product.setDeviceId(enterpriseProduct.getDeviceId());
        product.setEnterpriseId(enterpriseProduct.getEnterpriseId());

        int i = productDao.modify(product);
        if(1 == i)
            return ResultStatus.SUCCESS;
        else
            return ResultStatus.UNKNOWN_PRODUCT;
    }

    @Transactional
    public ResultStatus sell(int customerId, String productLocalId, String endUserLocalId,Date saleDatetime,String boilerName){
        CustomerProduct product = productDao.find(customerId,productLocalId);
        if(null == product){
            return ResultStatus.UNKNOWN_PRODUCT;
        }else if(product.getStatus() == CustomerProduct.STATUS_SOLD){
            return ResultStatus.SOLD_PRODUCT;
        }
        EndUser endUser = endUserDao.find(customerId,endUserLocalId);
        if(null == endUser){
            return  ResultStatus.UNKNOWN_ENDUSER;
        }

        CustomerSaleRecord saleRecord = new CustomerSaleRecord();
        saleRecord.setCustomerId(customerId);
        saleRecord.setProductLocalId(productLocalId);
        saleRecord.setEndUserLocalId(endUserLocalId);
        saleRecord.setSaleDatetime(saleDatetime);
        saleRecordDao.add(saleRecord);

        productDao.changeStatus(CustomerProduct.STATUS_SOLD, customerId,productLocalId);
        enterpriseSaleRecordForCustomerDao.setEndUser(endUser.getId(),product.getEnterpriseProductCode(),customerId);
        deviceDao.changeNickName(boilerName,product.getDeviceId());
        return ResultStatus.SUCCESS;
    }
}
