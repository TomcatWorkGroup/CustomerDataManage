package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.entity.db.CustomerProduct;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.service.CustomerProductService;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private CustomerProductService service;

    @PostMapping(value = "/add")
    public String add(CustomerProduct product) {

        ResultStatus status = service.add(product);
        return ResultStatusJsonStringUtil.getStatusString(status);

    }

    @PostMapping(value = "/remove")
    public String remove(int customerId, String localId) {
        ResultStatus s = service.remove(customerId, localId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/modify")
    public String modify(CustomerProduct product) {
        ResultStatus s = service.modify(product);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    @PostMapping(value = "/sell")
    public String sell(int customerId, String productLocalId, String endUserLocalId, String saleDatetime) throws Exception {
        Date date = format.parse(saleDatetime);
        return ResultStatusJsonStringUtil.getStatusString(service.sell(customerId, productLocalId, endUserLocalId, date));
    }
}
