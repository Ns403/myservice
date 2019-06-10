package com.myservice.service;

import com.myservice.Vo.FileInfoVo;

import java.util.List;

public interface FileService {
    /**
     * 查询出所有的文件
     * @return
     */
    List<FileInfoVo> getFilesInfo();

    /**
     * 上传文件
     * @param fileInfoVo 返回文件信息
     * @return 0失败，1成功
     */
    void uploadFile(FileInfoVo fileInfoVo);

    byte[] downloadFile(FileInfoVo fileInfoVo);

    void delFile(FileInfoVo fileInfoVo);
}
