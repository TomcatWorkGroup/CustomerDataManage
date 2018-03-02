package com.itdreamworks.customerdatamanage.mapper2;

import com.itdreamworks.customerdatamanage.entity.db.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CustomerEmployeeMapper2 {
    int remove(@Param("orgId") int orgId, @Param("loginId") String loginId);
    int changeStatus(@Param("status") int status, @Param("orgId") int orgId, @Param("loginId") String loginId);
    int add(Employee employee);
    Employee find(@Param("orgId") int orgId, @Param("loginId") String loginId);
    Employee findByLoginId(@Param("loginId") String loginId);
    int modify(Employee employee);
}
