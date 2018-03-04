package com.itdreamworks.customerdatamanage.handler;

import com.itdreamworks.customerdatamanage.entity.enums.ResultStatus;
import com.itdreamworks.customerdatamanage.utils.ResultStatusJsonStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) throws IOException {
        log.error(e.getMessage());
        return ResultStatusJsonStringUtil.getStatusString(ResultStatus.ERROR,"程序内部错误！");
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleException(DataIntegrityViolationException e) throws IOException {
        log.error(e.getMessage());
        return ResultStatusJsonStringUtil.getStatusString(ResultStatus.ERROR,
                e.getCause().getMessage());
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public String handleException(DuplicateKeyException e) throws IOException {
        log.error(e.getMessage());
        return ResultStatusJsonStringUtil.getStatusString(ResultStatus.ERROR,e.getCause().getMessage());
    }

}
