package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.db.EndUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CustomerEndUserMapper2 {
    int add(EndUser endUser);

    int remove(@Param("customerId") int customerId, @Param("localId") String localId);

    int changeStatus(@Param("status") int status,
                     @Param("customerId") int customerId,
                     @Param("localId") String localId);

    int modify(EndUser endUser);

    EndUser find(@Param("customerId") int customerId, @Param("localId") String localId);
}
