package com.itdreamworks.customerdatamanage.mapper2;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EnterpriseSaleRecordForCustomerMapper2 {
    int setEndUser(@Param("endUserId") int endUserId, @Param("enterpriseProductCode") String enterpriseProductCode, @Param("customerId") int customerId);
}
