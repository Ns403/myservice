package com.myservice.controller;


import com.myservice.Vo.FileInfoVo;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Controller
public class controllerIndex {
    @Autowired
    UploadFilesService uploadFilesService;
    /**
     * 显示主页
     * @return
     */
    @GetMapping("/index")
    public String controllerNmae() {
        List<FileInfoVo> filesInfo=uploadFilesService.getFilesInfo();
        return "index";
    }
}
