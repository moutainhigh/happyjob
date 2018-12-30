package com.happy.migrate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alibaba.fastjson.JSONObject;
import com.happy.HappySpringBoot;
import com.happy.util.pubConst.Const;
import com.happy.util.pubConst.ResultMsg;
/**
 * @TODO: 全局异常处理
 *
 */
@ControllerAdvice(basePackageClasses = HappySpringBoot.class)
public class MigrateControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MigrateControllerAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        JSONObject json = new JSONObject();
        json.put(Const.RESUTL_MESSAGE_ERRORCODE, ResultMsg.PUBLIC_RESULT_CODE_5);
        json.put(Const.RESUTL_MESSAGE_MESSAGE, ResultMsg.PUBLIC_RESULT_CONTENT_5);
        json.put(Const.RESUTL_MESSAGE_ERROR_DESC, ex.getMessage());
        logger.error("接口产生异常==",ex);
        return new ResponseEntity<>(json, status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}