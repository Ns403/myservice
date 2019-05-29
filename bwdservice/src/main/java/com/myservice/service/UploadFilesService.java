package com.myservice.service;

import com.myservice.Vo.FileInfoVo;

import java.util.List;

public interface UploadFilesService {
    /**
     * 查询出所有的文件
     * @return
     */
    List<FileInfoVo> getFilesInfo();

}
