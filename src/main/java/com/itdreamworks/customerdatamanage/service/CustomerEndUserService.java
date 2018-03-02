package com.itdreamworks.customerdatamanage.service;

import com.itdreamworks.customerdatamanage.entity.db.EndUser;
import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.mapper2.CustomerEndUserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEndUserService {
    @Autowired
    private CustomerEndUserMapper2 dao;

    public ResultStatus add(EndUser endUser){
        dao.add(endUser);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus remove(int customerId,String localId){
        dao.remove(customerId,localId);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus changeStatus(int status,
                     int customerId,
                     String localId){
        dao.changeStatus(status,customerId,localId);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus modify(EndUser endUser){
        dao.modify(endUser);
        return ResultStatus.SUCCESS;
    }

}
