package com.myservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10479
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String resultString(){
        return "11231231";
    }
}
