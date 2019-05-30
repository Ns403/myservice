package com.myservice.dao;

import com.myservice.bean.UploadFilesInfo;
import com.myservice.bean.UploadFilesInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadFilesInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    long countByExample(UploadFilesInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int deleteByExample(UploadFilesInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int insert(UploadFilesInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int insertSelective(UploadFilesInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    List<UploadFilesInfo> selectByExample(UploadFilesInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    UploadFilesInfo selectByPrimaryKey(Integer id);

    /**
     * 给idc查询id所在的文件，不给查询全部
     * @param id
     * @return
     */
    List<UploadFilesInfo> selectByPrimaryKeyWithAll(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int updateByExampleSelective(@Param("record") UploadFilesInfo record, @Param("example") UploadFilesInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int updateByExample(@Param("record") UploadFilesInfo record, @Param("example") UploadFilesInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int updateByPrimaryKeySelective(UploadFilesInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_upload_files_info
     *
     * @mbg.generated Thu May 30 09:25:13 CST 2019
     */
    int updateByPrimaryKey(UploadFilesInfo record);
}