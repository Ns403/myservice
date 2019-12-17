package com.myservice.controller;

import com.myservice.result.ResultEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * @author 10479
 */
@RestController
public class TestController  {
    @PostMapping("/test")
    public Object resultString(){
        return ResultEnum.REQUEST_OK.wrap();
    }

}
