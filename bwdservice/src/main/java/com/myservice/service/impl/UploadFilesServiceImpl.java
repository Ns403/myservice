package com.myservice.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.myservice.Vo.FileInfoVo;
import com.myservice.bean.UploadFilesInfo;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.service.UploadFilesService;
import com.myservice.utils.Md5Utils;
import com.myservice.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UploadFilesServiceImpl implements UploadFilesService {
    @Value("${service.address}")
    private String serverPath;

    @Autowired(required = false)
    UploadFilesInfoMapper uploadFilesInfoMapper;

    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @Override
    public List<FileInfoVo> getFilesInfo() {
        List<UploadFilesInfo> uploadFilesInfos = uploadFilesInfoMapper.selectByPrimaryKeyWithAll(null);
        List<FileInfoVo> fileInfoVos = new ArrayList<>();
        for (UploadFilesInfo uploadFilesInfo : uploadFilesInfos) {
            FileInfoVo fileInfoVo = new FileInfoVo();
            BeanUtils.copyProperties(uploadFilesInfo, fileInfoVo);
            fileInfoVo.setCreateTime(TimeUtils.timeConversion(uploadFilesInfo.getCreateTime()));
            fileInfoVo.setDelTime(TimeUtils.timeConversion(uploadFilesInfo.getDelTime()));
//            System.out.println(fileInfoVo.toString());
            fileInfoVos.add(fileInfoVo);
        }
        return fileInfoVos;
    }

    @Override
    public int uploadFile(FileInfoVo fileInfoVo) {
        fileInfoVo.setCreateTime(TimeUtils.timeConversion(new Date()));
        fileInfoVo.setFileMd5(Md5Utils.getFileMd5(fileInfoVo.getFile()));
        try {
//            if ()
            StorePath storePath = fastFileStorageClient.uploadFile(fileInfoVo.getFile().getInputStream(), fileInfoVo.getFile().getSize(), getExtension(fileInfoVo.getFile().getOriginalFilename()), null);
            fileInfoVo.setFileUrl(serverPath + storePath.getFullPath());
            log.info("FileInfoVo对象：{}", fileInfoVo.toString());
            return 0;
        } catch (Exception e) {
            log.error("文件上传失败文件名：{}；错误信息：{}",fileInfoVo.getFile().getOriginalFilename(),3);
            return 1;
        }

    }
    public String getExtension(String fileName){
        return StringUtils.substringAfterLast(fileName,".");
    }
}
