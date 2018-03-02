package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.db.CustomerCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerCategoryMapper2 {
    List<CustomerCategory> findAllOfCustomer(@Param("customerId") int customerId);
    CustomerCategory find(@Param("customerId") int customerId, @Param("localId") String localId);
    int remove(@Param("customerId") int customerId, @Param("localId") String localId);
    int changeCategoryName(@Param("categoryName") String categoryName, @Param("customerId") int customerId, @Param("localId") String localId);
    int add(CustomerCategory customerCategory);
}
