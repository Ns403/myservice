package com.myservice.controller;

import com.myservice.result.ResultEnum;
import com.myservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 10479
 */
@RestController
public class TestController  {
    @Autowired
    TestService testService;
    @PostMapping("/test")
    public Object resultString(){
        return ResultEnum.REQUEST_OK.result();
    }
    @PostMapping("/test/es")
    public Object testElasticSearch() {
        testService.testes();
        return null;
    }

}
