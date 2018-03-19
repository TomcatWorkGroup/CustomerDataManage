package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.db.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceMapper2Test {

    @Autowired
    DeviceMapper2 dao;
    @Test
    public void find() {
        Device device = dao.find(1);
        assertEquals(1,device.getId());
    }

    @Test
    public void changeNickName() {
        assertEquals(1,dao.changeNickName("南厂区锅炉1",1));
    }
}