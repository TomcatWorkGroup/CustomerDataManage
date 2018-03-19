package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerProductServiceTest {

    @Autowired
    CustomerProductService service;
    @Test
    public void sell() {
        ResultStatus s = service.sell(2,
                "p002",
                "2",
                new Date(),"测试");
        assertEquals(ResultStatus.SUCCESS,s);
    }
}