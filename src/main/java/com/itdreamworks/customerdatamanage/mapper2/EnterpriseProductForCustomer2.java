package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.EnterpriseProduct;
import com.itdreamworks.customerdatamanage.entity.EnterpriseProductForCustomerView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface EnterpriseProductForCustomer2 {
    List<EnterpriseProductForCustomerView> getTransactionRecords(@Param("startDatetime") Date startDatetime);
    EnterpriseProduct getProduct(@Param("productCode") String productCode);
}
