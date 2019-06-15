package com.myservice.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.myservice.Vo.FileInfoVo;
import com.myservice.bean.UploadFilesInfo;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.service.FileService;
import com.myservice.service.wrapper.FastDFSClientWrapper;
import com.myservice.utils.AssertUtils;
import com.myservice.utils.Md5Utils;
import com.myservice.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Value("${service.address}")
    private String serverPath;

    @Autowired(required = false)
    UploadFilesInfoMapper uploadFilesInfoMapper;

    @Autowired
    FastFileStorageClient fastFileStorageClient;
    @Autowired
    FastDFSClientWrapper fastDFSClientWrapper;

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
//            log.error("测试：{}",StorageUnitConversion(uploadFilesInfo.getFileSize()));
            fileInfoVo.setFileSize(StorageUnitConversion(uploadFilesInfo.getFileSize()));

            fileInfoVos.add(fileInfoVo);
        }
        return fileInfoVos;
    }

    @Override
    public void uploadFile(FileInfoVo fileInfoVo) {

        AssertUtils.assertTrue(fileInfoVo.getFile().isEmpty(), "上传文件为空！");
        if ("".equals(fileInfoVo.getFileName()) || fileInfoVo.getFileName() == null) {
            fileInfoVo.setFileName(fileInfoVo.getFile().getOriginalFilename());
        } else {
            fileInfoVo.setFileName(getFileName(fileInfoVo.getFileName()) +"."+ getExtension(fileInfoVo.getFile().getOriginalFilename()));
//            log.error("测试》》》》》》》》》{}",fileInfoVo.getFileName());
        }
//        AssertUtils.isTrue(true, "测试中");
        fileInfoVo.setCreateTime(TimeUtils.timeConversion(new Date()));
        fileInfoVo.setFileMd5(Md5Utils.getFileMd5(fileInfoVo.getFile()));
        UploadFilesInfo filesInfo = uploadFilesInfoMapper.selectByPrimaryKeyWithMD5(fileInfoVo.getFileMd5());
        if (filesInfo != null) {
            AssertUtils.assertTrue(fileInfoVo.getFileMd5().equals(filesInfo.getFileMd5()), "已存在相同文件！");
        }
        StorePath storePath = null;
        try {
            log.info("上传文件信息为：{}",fileInfoVo.toString());
//            storePath = fastFileStorageClient.uploadFile(fileInfoVo.getFile().getInputStream(), fileInfoVo.getFile().getSize(), getExtension(fileInfoVo.getFile().getOriginalFilename()), null);
            storePath = fastDFSClientWrapper.uploadFile(fileInfoVo.getFile());
//            throw new IOException();
        } catch (Exception e) {
            log.error("e.getMessage>>>>>{}", e.getMessage());
            AssertUtils.throwServiceException("上传文件失败！！", e);
        }
        fileInfoVo.setFileUrl(serverPath + storePath.getFullPath());
        fileInfoVo.setFastGroup(storePath.getGroup());
        fileInfoVo.setFastPath(storePath.getPath());

        UploadFilesInfo uploadFilesInfo = new UploadFilesInfo();
        BeanUtils.copyProperties(fileInfoVo, uploadFilesInfo);
        uploadFilesInfo.setCreateTime(new Date());
        uploadFilesInfo.setFileSize((int) fileInfoVo.getFile().getSize());

        log.info("uploadFilesInfo：{}", uploadFilesInfo.toString());
        try {
            log.info("uploadFilesInfo:{}",uploadFilesInfo.toString());
            uploadFilesInfoMapper.insertSelective(uploadFilesInfo);
        } catch (Exception e) {
            fastFileStorageClient.deleteFile(storePath.getFullPath());
            AssertUtils.throwServiceException("保存到数据库异常！", e);
        }

    }

    @Override
    public byte[] downloadFile(FileInfoVo fileInfoVo) {
        if (fileInfoVo == null) {
            AssertUtils.throwServiceException("指定参数为空");
        }
        if (fileInfoVo.getFastGroup() == null||fileInfoVo.getFastPath()==null) {
            AssertUtils.throwServiceException("指定参数为空");
        }
        try {
            return fastDFSClientWrapper.downloadFile(fileInfoVo.getFastGroup(), fileInfoVo.getFastPath());
        } catch (Exception e) {
            log.error("e.getMessage>>>>>{}", e.getMessage());
            AssertUtils.throwServiceException("下载文件异常",e);
        }
        return null;
    }

    @Override
    public void delFile(FileInfoVo fileInfoVo) {

    }

    private String getFileName(String fileName) {
        return StringUtils.substringBefore(fileName, ".");
    }

    private String getExtension(String fileName) {
        return StringUtils.substringAfterLast(fileName, ".");
    }

    private static String StorageUnitConversion(Integer fileSize) {
        if (fileSize != null) {
            int i = 0;
            DecimalFormat format = new DecimalFormat("0.00");
            double result = fileSize;
            while (result > 1024) {
                result /= 1024;
                i++;
            }
            String format1 = format.format(result);
            switch (StorageUnit.getStorageUnit(i)) {
                case UNITBUTE:
                    return format1 + " " + StorageUnit.getStorageUnit(i).getUnitName();
                case UNITKB:
                    return format1 + " " + StorageUnit.getStorageUnit(i).getUnitName();
                case UNITMB:
                    return format1 + " " + StorageUnit.getStorageUnit(i).getUnitName();
                case UNITGB:
                    return format1 + " " + StorageUnit.getStorageUnit(i).getUnitName();
                case UNITTB:
                    return format1 + " " + StorageUnit.getStorageUnit(i).getUnitName();
                case UNITPB:
                    return format1 + " " + StorageUnit.getStorageUnit(i).getUnitName();
                default:
                    return "——";
            }
        } else {
            return "——";
        }

    }

    private  enum StorageUnit {
        UNITBUTE(0,"byte"),
        UNITKB(1, "KB"),
        UNITMB(2, "MB"),
        UNITGB(3, "GB"),
        UNITTB(4, "TB"),
        UNITPB(5, "PB"),

        ;

        private final Integer unitCode;
        private final String UnitName;
        public static StorageUnit getStorageUnit(Integer unitCode){
            for (StorageUnit storageUnit : values()) {
                if (storageUnit.getUnitCode().equals(unitCode)) {
                    return storageUnit;
                }
            }
            return null;
        }

        StorageUnit(Integer unitCode, String unitName) {
            this.unitCode = unitCode;
            this.UnitName = unitName;
        }

        public Integer getUnitCode() {
            return unitCode;
        }

        public String getUnitName() {
            return UnitName;
        }
    }
}
