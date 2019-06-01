package com.myservice.controller.resultpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
    /**
     * 显示主页
     *
     * @return
     */
    @GetMapping("/")
    public String controllerNmae(Integer pn) {
        return "index";
    }

    /**
     * 显示所有文件信息的界面
     *
     * @return
     */
    @GetMapping("/allFilePage")
    public String allFilePage() {
        return "filepage/allFilePage";
    }

    /**
     * 上传文件页面
     *
     * @return
     */
    @GetMapping("/uploadFilePage")
    public String uploadFilePage() {
        return "filepage/UploadFilePage";
    }
}
