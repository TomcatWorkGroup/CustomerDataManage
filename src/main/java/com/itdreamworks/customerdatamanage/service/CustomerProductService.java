package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.*;
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
    private EnterpriseSaleRecordForCustomerMapper2 enterpriseSaleRecordForCustomerDao;
    @Autowired
    private EnterpriseProductForCustomer2 enterpriseProductForCustomerDao;

    public DbEntityStatus add(CustomerProduct product) throws Exception{
        EnterpriseProduct enterpriseProduct = enterpriseProductForCustomerDao.getProduct(product.getEnterpriseProductCode());
        if(null == enterpriseProduct)
            return DbEntityStatus.UNKNOWN_PRODUCT;

        CustomerCategory category = categoryDao.find(product.getCustomerId(),product.getCategoryLocalId());
        if(null == category)
            return DbEntityStatus.UNKNOWN_CATEGORY;

        //补全关联信息
        product.setDeviceId(enterpriseProduct.getDeviceId());
        product.setEnterpriseId(enterpriseProduct.getEnterpriseId());
        productDao.add(product);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus remove(int customerId,String localId){
        CustomerProduct product = productDao.find(customerId,localId);
        if(null == product){
            return DbEntityStatus.UNKNOWN;
        }else if(product.getStatus() == CustomerProduct.STATUS_SOLD){
            return DbEntityStatus.SOLD;
        }else {
            productDao.remove(customerId,localId);
            return DbEntityStatus.SUCCESS;
        }
    }

    public DbEntityStatus modify(CustomerProduct product){
        EnterpriseProduct enterpriseProduct = enterpriseProductForCustomerDao.getProduct(product.getEnterpriseProductCode());
        if(null == enterpriseProduct)
            return DbEntityStatus.UNKNOWN_PRODUCT;

        CustomerCategory category = categoryDao.find(product.getCustomerId(),product.getCategoryLocalId());
        if(null == category)
            return DbEntityStatus.UNKNOWN_CATEGORY;

        //补全关联信息
        product.setDeviceId(enterpriseProduct.getDeviceId());
        product.setEnterpriseId(enterpriseProduct.getEnterpriseId());

        int i = productDao.modify(product);
        if(0 == i)
            return DbEntityStatus.UNKNOWN;
        else
            return DbEntityStatus.SUCCESS;
    }

    @Transactional
    public DbEntityStatus sell(int customerId, String productLocalId, String endUserLocalId,Date saleDatetime) throws Exception{
        CustomerProduct product = productDao.find(customerId,productLocalId);
        if(null == product){
            return DbEntityStatus.UNKNOWN;
        }else if(product.getStatus() == CustomerProduct.STATUS_SOLD){
            return DbEntityStatus.SOLD;
        }
        EndUser endUser = endUserDao.find(customerId,endUserLocalId);
        if(null == endUser){
            return  DbEntityStatus.UNKNOWN;
        }

        CustomerSaleRecord saleRecord = new CustomerSaleRecord();
        saleRecord.setCustomerId(customerId);
        saleRecord.setProductLocalId(productLocalId);
        saleRecord.setEndUserLocalId(endUserLocalId);
        saleRecord.setSaleDatetime(saleDatetime);
        saleRecordDao.add(saleRecord);

        productDao.changeStatus(CustomerProduct.STATUS_SOLD, customerId,productLocalId);
        enterpriseSaleRecordForCustomerDao.setEndUser(endUser.getId(),product.getEnterpriseProductCode(),customerId);
        return DbEntityStatus.SUCCESS;
    }
}
