package com.itdreamworks.customerdatamanage.mapper2;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CustomerDeviceEmployeeMapMapper2 {
    int add(@Param("employeeId") int employeeId, @Param("deviceId") int deviceId);
    int remove(@Param("employeeId") int employeeId, @Param("deviceId") int deviceId);
    int removeEmployeeMap(@Param("employeeId") int employeeId);
    int checkExists(@Param("employeeId") int employeeId, @Param("deviceId") int deviceId);
}
