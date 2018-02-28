package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CustomerMapper2 {
    Customer findById(@Param("id") int id);
    Customer findByCode(@Param("customerCode") String customerCode);
}
