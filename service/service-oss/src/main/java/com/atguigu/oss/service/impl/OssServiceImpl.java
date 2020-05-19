package com.atguigu.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Yangrj
 * @date 2020/5/19
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // 参数配置
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。

        try {
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            // 生成唯一的文件名称值，防止替换掉同名文件
            String uuid = UUID.randomUUID().toString().replace("-","");
            fileName = uuid + fileName;
            /*
             * 第一个是阿里云oos的bucket名称
             * 第二个参数是上传到oos的文件名称
             * 第三个参数是上传的文件流
             */
            ossClient.putObject(bucketName, fileName, inputStream);

            // 上传成功后返回的路径
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder = stringBuilder.append("https://")
                    .append(bucketName)
                    .append(endpoint)
                    .append(fileName);
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 关闭OSSClient。
        ossClient.shutdown();
        return null;
    }
}
