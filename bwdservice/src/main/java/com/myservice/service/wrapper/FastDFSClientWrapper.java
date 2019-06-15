package com.myservice.service.wrapper;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.myservice.utils.AssertUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FastDFS客户端包装类
 *
 * @Author wly
 * @Date 2018/6/13 9:46
 */
@Component
@Slf4j
public class FastDFSClientWrapper {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 文件上传
     *
     * @param bytes     文件字节
     * @param fileSize  文件大小
     * @param extension 文件扩展名
     * @return fastDfs路径
     */
    public String uploadFile(byte[] bytes, long fileSize, String extension) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        StorePath storePath = fastFileStorageClient.uploadFile(byteArrayInputStream, fileSize, extension, null);
        System.out.println(storePath.getGroup() + "===" + storePath.getPath() + "======" + storePath.getFullPath());
        return storePath.getFullPath();
    }
    public StorePath uploadFile(MultipartFile file) throws IOException {
        long size = file.getSize();
        String extension = getExtension(file.getOriginalFilename());
        File tempFile = File.createTempFile("temp" + getFileName(file.getOriginalFilename()), extension);
        try (FileInputStream fileInputStream = new FileInputStream(tempFile);) {
            log.info("临时文件目录：{}" , tempFile.getCanonicalPath());
            file.transferTo(tempFile);
            file = null;
            StorePath storePath = fastFileStorageClient.uploadFile(fileInputStream, size, extension, null);
            System.out.println(storePath.getGroup() + "===" + storePath.getPath() + "======" + storePath.getFullPath());
            return storePath;
        } catch (Exception e) {
            AssertUtils.throwServiceException("fdfs包装类上传失败！",e);
        }
        return null;
    }

    private String getFileName(String fileName) {
        return StringUtils.substringBefore(fileName, ".");
    }

    private String getExtension(String fileName) {
        return StringUtils.substringAfterLast(fileName, ".");
    }

    /**
     * 下载文件
     *
     * @return 文件字节
     * @throws IOException
     */
    public byte[] downloadFile(String group,String path) throws IOException {
        DownloadByteArray downloadByteArray = new DownloadByteArray();
        return fastFileStorageClient.downloadFile(group, path, downloadByteArray);
    }
}