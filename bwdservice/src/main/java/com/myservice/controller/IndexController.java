package com.myservice.controller;


import com.myservice.Vo.FileInfoVo;
import com.myservice.result.Msg;
import com.myservice.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class IndexController {
    @Autowired
    UploadFilesService uploadFilesService;

    /**
     * 返回信息
     * @return
     */
    @GetMapping("/index")
    public Msg resultInfo() {
        List<FileInfoVo> filesInfo = uploadFilesService.getFilesInfo();
        return Msg.sucess().addList(filesInfo);
    }
    /**
     * 上传文件
     * @return
     */
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("fileInfoVo") FileInfoVo fileInfoVo) {
        int bl = uploadFilesService.uploadFile(fileInfoVo);
        return null;
    }

}
