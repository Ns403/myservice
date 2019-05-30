package com.myservice;

import com.myservice.bean.UploadFilesInfo;
import com.myservice.dao.UploadFilesInfoMapper;
import com.myservice.utils.TimeUtils;
import com.mysql.cj.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BwdServiceApplicationTests {
    @Autowired
    SqlSession sqlSession;

    @Test
    public void contextLoads() {
        UploadFilesInfoMapper mapper = sqlSession.getMapper(UploadFilesInfoMapper.class);
        System.out.println();


//        for (int i = 0; i < 100; i++) {
//            String uuid = UUID.randomUUID().toString().split("-")[0];
//            mapper.insertSelective(new UploadFilesInfo(null, uuid, "txt", "www.baidu.com", "1", "asdfadsfafasdfadf", new Date(), TimeUtils.timeAddOrSub(new Date(), null, 1, null)));
//        }
        List<UploadFilesInfo> uploadFilesInfos = mapper.selectByPrimaryKeyWithAll(null);
        for (UploadFilesInfo uploadFilesInfo : uploadFilesInfos) {
//            System.out.println(uploadFilesInfo.toString());
                System.out.println(TimeUtils.timeConversion(uploadFilesInfo.getCreateTime()));
            System.out.println(uploadFilesInfo.getDelTime());
        }

    }

}
