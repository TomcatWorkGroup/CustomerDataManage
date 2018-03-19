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

/**
 * 产品管理 /product
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private CustomerProductService service;

    /**
     * 添加产品
     * @param product 产品对象
     * @return 执行结果
     */
    @PostMapping(value = "/add")
    public String add(CustomerProduct product) {

        ResultStatus status = service.add(product);
        return ResultStatusJsonStringUtil.getStatusString(status);

    }

    /**
     * 移除产品
     * 注意：已出售的产品不支持移除操作
     * @param localId 产品本地唯一标识
     * @return 执行结果
     */
    @PostMapping(value = "/remove")
    public String remove(int customerId, String localId) {
        ResultStatus s = service.remove(customerId, localId);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    /**
     * 修改产品基本信息
     * @param product 产品对象
     * @return 执行结果
     */
    @PostMapping(value = "/modify")
    public String modify(CustomerProduct product) {
        ResultStatus s = service.modify(product);
        return ResultStatusJsonStringUtil.getStatusString(s);
    }

    /**
     * 销售产品
     * @param productLocalId 产品本地唯一标识
     * @param endUserLocalId 产品销售到的客户本地唯一标识
     * @param saleDatetime 销售时间
     * @return 执行结果
     * @throws Exception 销售时间格式为 yyyy-MM-dd HH:mm:ss，否则将出现转换异常
     */
    @PostMapping(value = "/sell")
    public String sell(int customerId, String productLocalId, String endUserLocalId, String saleDatetime,String boilerName) throws Exception {
        Date date = format.parse(saleDatetime);
        return ResultStatusJsonStringUtil.getStatusString(service.sell(customerId, productLocalId, endUserLocalId, date,boilerName));
    }
}
