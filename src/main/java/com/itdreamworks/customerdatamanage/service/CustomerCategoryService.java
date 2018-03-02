package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.db.CustomerCategory;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
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
    public ResultStatus remove(int customerId, String localId) {
        productDao.removeCategory(customerId, localId);
        customerCategoryDao.remove(customerId, localId);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus changeCategoryName(String categoryName, int customerId, String localId) {
        customerCategoryDao.changeCategoryName(categoryName, customerId, localId);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus add(CustomerCategory customerCategory) {
        customerCategoryDao.add(customerCategory);
        return ResultStatus.SUCCESS;
    }
}
