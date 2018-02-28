package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.EndUser;
import com.itdreamworks.customerdatamanage.mapper2.CustomerEndUserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEndUserService {
    @Autowired
    private CustomerEndUserMapper2 dao;

    public DbEntityStatus add(EndUser endUser) throws Exception{
        dao.add(endUser);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus remove(int customerId,String localId){
        dao.remove(customerId,localId);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus changeStatus(int status,
                     int customerId,
                     String localId){
        dao.changeStatus(status,customerId,localId);
        return DbEntityStatus.SUCCESS;
    }

    public DbEntityStatus modify(EndUser endUser) throws Exception{
        dao.modify(endUser);
        return DbEntityStatus.SUCCESS;
    }

}
