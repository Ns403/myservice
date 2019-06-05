package com.myservice.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.myservice.Vo.FileInfoVo;
import com.myservice.bean.UploadFilesInfo;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.service.UploadFilesService;
import com.myservice.utils.AssertUtils;
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
//            fileInfoVo.setDelTime(TimeUtils.timeConversion(uploadFilesInfo.getDelTime()));
//            System.out.println(fileInfoVo.toString());
            fileInfoVos.add(fileInfoVo);
        }
        return fileInfoVos;
    }

    @Override
    public void uploadFile(FileInfoVo fileInfoVo) {

        AssertUtils.assertTrue(fileInfoVo.getFile().isEmpty(), "上传文件为空！");
        if ("".equals(fileInfoVo.getFileName()) || fileInfoVo.getFileName() == null) {
            fileInfoVo.setFileName(fileInfoVo.getFile().getOriginalFilename());
        }
        fileInfoVo.setCreateTime(TimeUtils.timeConversion(new Date()));
        fileInfoVo.setFileMd5(Md5Utils.getFileMd5(fileInfoVo.getFile()));
        UploadFilesInfo uploadFilesInfo1 = null;
        try {
            uploadFilesInfo1 = uploadFilesInfoMapper.selectByPrimaryKeyWithMD5(fileInfoVo.getFileMd5());
        } catch (Exception e) {
            log.info("唯一不做任何处理");
        }
        if (uploadFilesInfo1 != null) {
            AssertUtils.assertTrue(fileInfoVo.getFileMd5().equals(uploadFilesInfo1.getFileMd5()), "已存在相同文件！");
        }
        StorePath storePath = null;
        try {
            storePath = fastFileStorageClient.uploadFile(fileInfoVo.getFile().getInputStream(), fileInfoVo.getFile().getSize(), getExtension(fileInfoVo.getFile().getOriginalFilename()), null);
//            throw new IOException();
        } catch (Exception e) {
            AssertUtils.throwServiceException("上传文件失败！！", e);
        }
        fileInfoVo.setFileUrl(serverPath + storePath.getFullPath());
        log.info("FileInfoVo对象：{}", fileInfoVo.toString());

        UploadFilesInfo uploadFilesInfo = new UploadFilesInfo();
        BeanUtils.copyProperties(fileInfoVo, uploadFilesInfo);
        uploadFilesInfo.setCreateTime(new Date());
        log.info("uploadFilesInfo：{}", uploadFilesInfo.toString());
        try {
            uploadFilesInfoMapper.insertSelective(uploadFilesInfo);
        } catch (Exception e) {
            fastFileStorageClient.deleteFile(storePath.getFullPath());
            AssertUtils.throwServiceException("保存到数据库异常！",e);
        }

    }

    public String getExtension(String fileName) {
        return StringUtils.substringAfterLast(fileName, ".");
    }
}
