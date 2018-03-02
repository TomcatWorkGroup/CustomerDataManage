package com.itdreamworks.customerdatamanage.handler;

import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletResponse response, Exception e) throws IOException {
        return ResultStatusJsonStringUtil.getStatusString(ResultStatus.ERROR,"程序内部错误！");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleException(HttpServletResponse response, DataIntegrityViolationException e) throws IOException {
        return ResultStatusJsonStringUtil.getStatusString(ResultStatus.ERROR,
                e.getCause().getMessage());
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public String handleException(HttpServletResponse response, DuplicateKeyException e) throws IOException {
        return ResultStatusJsonStringUtil.getStatusString(ResultStatus.ERROR,
                e.getCause().getMessage());
    }

}
