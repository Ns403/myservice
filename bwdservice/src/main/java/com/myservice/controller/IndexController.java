package com.myservice.controller;


import com.myservice.Vo.FileInfoVo;
import com.myservice.result.ResponseEntity;
import com.myservice.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    UploadFilesService uploadFilesService;

    /**
     * 返回信息
     *
     * @return
     */
    @GetMapping("/index")
    public ResponseEntity resultInfo() {
        List<FileInfoVo> filesInfo = uploadFilesService.getFilesInfo();
        return ResponseEntity.ok().add(1, filesInfo);
    }

    /**
     * 上传文件
     *
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity uploadFile( FileInfoVo fileInfoVo) {

        uploadFilesService.uploadFile(fileInfoVo);
        return ResponseEntity.ok("文件上传成功！");
    }
}
