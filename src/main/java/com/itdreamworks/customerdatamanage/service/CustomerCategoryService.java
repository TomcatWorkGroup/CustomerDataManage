package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.CustomerCategory;
import com.itdreamworks.customerdatamanage.mapper2.CustomerCategoryMapper2;
import com.itdreamworks.customerdatamanage.mapper2.CustomerProductMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerCategoryService {
    @Autowired
    private CustomerProductMapper2 productDao;
    @Autowired
    private CustomerCategoryMapper2 customerCategoryDao;

    @Transactional
    public DbEntityStatus remove(int customerId, String localId) throws Exception{
        productDao.removeCategory(customerId, localId);
        customerCategoryDao.remove(customerId, localId);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus changeCategoryName(String categoryName, int customerId, String localId) {
        customerCategoryDao.changeCategoryName(categoryName, customerId, localId);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus add(CustomerCategory customerCategory) throws Exception {
        customerCategoryDao.add(customerCategory);
        return DbEntityStatus.SUCCESS;
    }
}
