package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.EnterpriseProductForCustomerView;
import com.itdreamworks.customerdatamanage.mapper2.EnterpriseProductForCustomer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 采购记录管理 /records
 */
@RestController
@RequestMapping(value = "/records")
public class ProcurementRecordsController {

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private EnterpriseProductForCustomer2 dao;

    /**
     * 获取采购记录信息
     * @param startDatetime 要获取的采购记录生成时间
     * @return 采购记录列表
     * @throws ParseException startDatetime格式为yyyy-MM-dd HH:mm:ss，否则将出现转换异常
     */
    @PostMapping(value = "/get")
    public List<EnterpriseProductForCustomerView> getRecords(int customerId, String startDatetime) throws ParseException {
        Date date = format.parse(startDatetime);
        return dao.getTransactionRecords(customerId,date);
    }

}
