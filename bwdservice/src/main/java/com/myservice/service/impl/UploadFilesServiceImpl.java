package com.myservice.service.impl;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.myservice.Vo.FileInfoVo;
import com.myservice.bean.UploadFilesInfo;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.service.UploadFilesService;
import com.myservice.utils.Md5Utils;
import com.myservice.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {
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
        String fileMd5 = Md5Utils.getFileMd5(fileInfoVo.getFile());
        if (StringUtils.isEmpty(fileMd5)) {
            return 0;
        }
        System.out.println(fileMd5);
        return 1;
    }
}
