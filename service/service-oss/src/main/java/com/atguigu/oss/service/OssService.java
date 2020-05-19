package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Yangrj
 * @date 2020/5/19
 */
public interface OssService {
    /**
     * 上传文件到阿里oss
     *
     * @param file
     * @return java.lang.String
     * @author Yangrj
     * @date 2020/5/19
     */
    String uploadFileAvatar(MultipartFile file);
}
