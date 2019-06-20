package com.myservice.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myservice.Vo.FileInfoVo;
import com.myservice.result.ResponseEntity;
import com.myservice.service.FileService;
import com.myservice.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class IndexController {
    @Autowired
    FileService filesService;

    /**
     * 返回信息
     *
     * @return
     */
    @GetMapping("/index")
    public ResponseEntity resultInfo(@RequestParam(value = "pn",defaultValue = "1") Integer PageNo) {
        PageHelper.startPage(PageNo, 10);
        List<FileInfoVo> filesInfo = filesService.getFilesInfo();
        PageInfo<FileInfoVo> pageInfo=new PageInfo<>(filesInfo,5);
        return ResponseEntity.ok().add("pageInfo", pageInfo);
    }

    /**
     * 上传文件
     *
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity uploadFile(FileInfoVo fileInfoVo) {
        filesService.uploadFile(fileInfoVo);
        return ResponseEntity.ok("文件上传成功！");
    }

    /**
     * 下载文件
     *
     */
    @PostMapping("/download")
    public ResponseEntity downloadFile(FileInfoVo fileInfoVo, HttpServletResponse response) {
        byte[] bytes = filesService.downloadFile(fileInfoVo);
        if (fileInfoVo.getFileName() == null) {
            AssertUtils.throwServiceException("文件名为空");
        }
        // 这里只是为了整合fastdfs，所以写死了文件格式。需要在上传的时候保存文件名。下载的时候使用对应的格式
        try (ServletOutputStream outputStream = response.getOutputStream()){
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileInfoVo.getFileName(), "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            outputStream.write(bytes);
        } catch (IOException e) {
            AssertUtils.throwServiceException("接口异常，下载失败！", e);
        }
        return ResponseEntity.ok("下载成功！");
    }

    /**
     * @return
     */
    @GetMapping("/delFile")
    public ResponseEntity delFile(FileInfoVo fileInfoVo) {
        filesService.delFile(fileInfoVo);
        return ResponseEntity.ok();
    }
}
