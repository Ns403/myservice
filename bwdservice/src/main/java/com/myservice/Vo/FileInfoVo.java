package com.myservice.Vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileInfoVo {
    /**
     * Id
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    private Integer id;

    /**
     * 文件名
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
//    @NotBlank(message = "文件名不能为空")
    private String fileName;

    /**
     * 文件类型
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    private String fileType;

    /**
     *
     * 下载链接
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    private String fileUrl;

    /**
     * 状态0，显示1，隐藏
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    private String status;

    /**
     * 文件的md5
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    private String fileMd5;

    /**
     * 创建时间
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    private String createTime;

    /**
     * 失效时间
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
//    private String delTime;
    /**
     * 文件
     */
    private MultipartFile file;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件组别
     */
    private String fastGroup;
    /**
     * 文件地址
     */
    private String fastPath;

    @Override
    public String toString() {
        return "FileInfoVo{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", status='" + status + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                ", createTime='" + createTime + '\'' +
                ", file=" + file .getOriginalFilename()+
                ", fileSize='" + fileSize + '\'' +
                ", fastGroup='" + fastGroup + '\'' +
                ", fastPath='" + fastPath + '\'' +
                '}';
    }
}
