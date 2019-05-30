package com.myservice.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myservice.Vo.FileInfoVo;
import com.myservice.result.Msg;
import com.myservice.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class IndexController {
    @Autowired
    UploadFilesService uploadFilesService;


    /**
     * 显示主页
     *
     * @return
     */
    @GetMapping("/")
    public String controllerNmae(Integer pn) {
        return "index";
    }

    /**
     * 返回信息
     * @return
     */
    @ResponseBody
    @GetMapping("/index")
    public Msg resultInfo(@RequestParam(defaultValue = "1") int pn) {
        PageHelper.startPage(pn, 5);
        List<FileInfoVo> filesInfo = uploadFilesService.getFilesInfo();
        PageInfo<FileInfoVo> pageInfo = new PageInfo<>(filesInfo);
        return Msg.sucess().add("pageInfo",pageInfo);
    }
}
