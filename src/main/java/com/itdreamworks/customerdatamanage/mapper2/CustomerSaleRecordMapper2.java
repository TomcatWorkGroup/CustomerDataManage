package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.CustomerSaleRecord;
import org.springframework.stereotype.Component;

@Component
public interface CustomerSaleRecordMapper2 {
    int add(CustomerSaleRecord customerSaleRecord);
}
