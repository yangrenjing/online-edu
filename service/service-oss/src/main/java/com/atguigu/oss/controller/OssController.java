package com.atguigu.oss.controller;

import com.atguigu.oss.service.OssService;
import com.atguigu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Yangrj
 * @date 2020/5/19
 */
@RestController
@RequestMapping("edu/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("")
    public R uploadOssFile(MultipartFile file) {
        /*上传头像*/
        return R.ok().data(ossService.uploadFileAvatar(file));
    }
}
