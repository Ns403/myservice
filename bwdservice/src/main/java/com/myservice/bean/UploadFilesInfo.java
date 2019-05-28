package com.myservice.bean;

import java.util.Date;

public class UploadFilesInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.id
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.file_name
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private String fileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.file_type
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private String fileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.status
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.file_md5
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private String fileMd5;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.create_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.edit_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private Date editTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.expire_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private Date expireTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_upload_files_info.del_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    private Date delTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.id
     *
     * @return the value of tbl_upload_files_info.id
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.id
     *
     * @param id the value for tbl_upload_files_info.id
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.file_name
     *
     * @return the value of tbl_upload_files_info.file_name
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.file_name
     *
     * @param fileName the value for tbl_upload_files_info.file_name
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.file_type
     *
     * @return the value of tbl_upload_files_info.file_type
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.file_type
     *
     * @param fileType the value for tbl_upload_files_info.file_type
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.status
     *
     * @return the value of tbl_upload_files_info.status
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.status
     *
     * @param status the value for tbl_upload_files_info.status
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.file_md5
     *
     * @return the value of tbl_upload_files_info.file_md5
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public String getFileMd5() {
        return fileMd5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.file_md5
     *
     * @param fileMd5 the value for tbl_upload_files_info.file_md5
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5 == null ? null : fileMd5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.create_time
     *
     * @return the value of tbl_upload_files_info.create_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.create_time
     *
     * @param createTime the value for tbl_upload_files_info.create_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.edit_time
     *
     * @return the value of tbl_upload_files_info.edit_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.edit_time
     *
     * @param editTime the value for tbl_upload_files_info.edit_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.expire_time
     *
     * @return the value of tbl_upload_files_info.expire_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.expire_time
     *
     * @param expireTime the value for tbl_upload_files_info.expire_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_upload_files_info.del_time
     *
     * @return the value of tbl_upload_files_info.del_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public Date getDelTime() {
        return delTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_upload_files_info.del_time
     *
     * @param delTime the value for tbl_upload_files_info.del_time
     *
     * @mbg.generated Tue May 28 16:27:53 CST 2019
     */
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }
}