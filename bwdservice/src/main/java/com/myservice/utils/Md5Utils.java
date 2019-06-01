package com.myservice.utils;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Utils {
    //    MessageDigest.getInstance("MD5)
    public static String getFileMd5(MultipartFile file) {
        try {
            byte[] uploadBytes = file.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            String hashString = new BigInteger(1, digest).toString(16);
            return hashString.toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException("文件生成MD5失败！",e);
        }

    }
}
