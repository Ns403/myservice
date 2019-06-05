package com.myservice.controller.error;

import com.myservice.result.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(HttpServletResponse response, Exception exception) throws Exception {
        log.error("全局异常拦截", exception);
        return handleErrorInfo(response, exception.getMessage(), exception);
    }
    private ResponseEntity handleErrorInfo(HttpServletResponse response, String message, Exception exception) {
        log.error("全局异常返回", exception);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        ResponseEntity responseEntity = new ResponseEntity<>();
        responseEntity.setStatusMessage(message);
        responseEntity.setStatusCode("500");
        responseEntity.setResponseContent(exception);
        return responseEntity;
    }
}
