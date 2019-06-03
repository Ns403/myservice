package com.myservice;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BwdServiceApplicationTests {
    @Autowired
    SqlSession sqlSession;
    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @Test
    public void contextLoads() {
//        UploadFilesInfoMapper mapper = sqlSession.getMapper(UploadFilesInfoMapper.class);
//        System.out.println();

        fastFileStorageClient.deleteFile("group1/M00/00/00/aPMbZ1z1cIeADMZpAAXy9HHZEi4778.pdf");
//        for (int i = 0; i < 100; i++) {
//            String uuid = UUID.randomUUID().toString().split("-")[0];
//            mapper.insertSelective(new UploadFilesInfo(null, uuid, "txt", "www.baidu.com", "1", "asdfadsfafasdfadf", new Date(), TimeUtils.timeAddOrSub(new Date(), null, 1, null)));
//        }
//        List<UploadFilesInfo> uploadFilesInfos = mapper.selectByPrimaryKeyWithAll(null);
//        for (UploadFilesInfo uploadFilesInfo : uploadFilesInfos) {
////            System.out.println(uploadFilesInfo.toString());
//                System.out.println(TimeUtils.timeConversion(uploadFilesInfo.getCreateTime()));
//            System.out.println(uploadFilesInfo.getDelTime());
//        }

    }

}
