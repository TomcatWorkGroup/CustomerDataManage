package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.CustomerProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CustomerProductMapper2 {
    CustomerProduct find(@Param("customerId") int customerId, @Param("localId") String localId);
    int remove(@Param("customerId") int customerId, @Param("localId") String localId);
    int add(CustomerProduct customerProduct);
    int modify(CustomerProduct customerProduct);
    int changeStatus(@Param("status") int status, @Param("customerId") int customerId, @Param("localId") String localId);
    int removeCategory(@Param("customerId") int customerId, @Param("categoryLocalId") String categoryLocalId);
}
