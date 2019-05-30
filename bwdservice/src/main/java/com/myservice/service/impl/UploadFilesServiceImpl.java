package com.myservice.service.impl;

import com.myservice.Vo.FileInfoVo;
import com.myservice.bean.UploadFilesInfo;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.service.UploadFilesService;
import com.myservice.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {
    @Autowired(required = false)
    UploadFilesInfoMapper uploadFilesInfoMapper;

    @Override
    public List<FileInfoVo> getFilesInfo() {
        List<UploadFilesInfo> uploadFilesInfos = uploadFilesInfoMapper.selectByPrimaryKeyWithAll(null);
        List<FileInfoVo> fileInfoVos = new ArrayList<>();
        FileInfoVo fileInfoVo = new FileInfoVo();
        for (UploadFilesInfo uploadFilesInfo : uploadFilesInfos) {
            BeanUtils.copyProperties(uploadFilesInfo, fileInfoVo);
            fileInfoVo.setCreateTime(TimeUtils.timeConversion(uploadFilesInfo.getCreateTime()));
            fileInfoVo.setDelTime(TimeUtils.timeConversion(uploadFilesInfo.getDelTime()));
            System.out.println(fileInfoVo.toString());
            fileInfoVos.add(fileInfoVo);
        }
        return fileInfoVos;
    }
}
