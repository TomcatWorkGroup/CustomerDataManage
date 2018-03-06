package com.itdreamworks.customerdatamanage.controller;

import com.itdreamworks.customerdatamanage.CustomerdatamanageApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerdatamanageApplication.class)
@WebMvcTest
public class ProcurementRecordsControllerTest {
    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private WebApplicationContext wac;

    @Before
    public void setup(){
        //MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        //单个类  拦截器无效
        //mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void getRecords() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/records/get").
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("customerId","2").
                        param("startDatetime","2017-01-01 00:00:00")
        ).andReturn();
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("正确",200 == status);
        Assert.assertFalse("错误",200 != status);
        System.out.println("status->"+status);
        System.out.println(content);
    }
}