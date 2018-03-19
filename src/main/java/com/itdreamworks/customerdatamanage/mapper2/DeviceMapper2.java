package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.db.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DeviceMapper2 {
    Device find(@Param("id") int id);
    int changeNickName(@Param("nickName") String nickName,@Param("id") int id);
}
