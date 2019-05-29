package com.myservice.service.impl;

import com.myservice.Vo.FileInfoVo;
import com.myservice.bean.UploadFilesInfo;
import com.myservice.bean.UploadFilesInfoExample;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.service.UploadFilesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {
    @Autowired(required = false)
    UploadFilesInfoMapper uploadFilesInfoMapper;
    @Override
    public List<FileInfoVo> getFilesInfo() {
        UploadFilesInfo uploadFilesInfo = uploadFilesInfoMapper.selectByPrimaryKey(3);
        System.out.println(uploadFilesInfo.toString());
        System.out.println("----------------------------------");
        System.out.println();
//        BeanUtils.copyProperties();
        return null;
    }
}
