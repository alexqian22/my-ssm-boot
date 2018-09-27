package com.enreach.ssm.conf;

import com.enreach.ssm.infrastructure.BizException;
import com.enreach.ssm.infrastructure.ErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BizException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBizException(HttpServletRequest request, BizException ex) {
        //html请求交给spring boot 默认处理
        if (request.getHeader("accept").contains("text/html")) {
            throw ex;
        }

        int code = 400;
        if (ex.getErrorEnum() != null) {
            code = ex.getErrorEnum().getState();
        }
        ErrorResult errorResult = new ErrorResult(code, ex.getMessage(), ex.getData());
        errorResult.setPath(request.getServletPath());
        return errorResult;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult handleDefaultException(HttpServletRequest request, Exception ex) throws Exception {
        if (request.getHeader("accept").contains("text/html")) {
            throw ex;
        }

        ErrorResult errorResult = new ErrorResult(500, "系统错误", ex.getMessage());
        errorResult.setPath(request.getServletPath());
        LOG.error("--> request url :" + request.getRequestURL(), ex);
        return errorResult;
    }

}
