package com.opzpy123.zweb3.s3.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.opzpy123.zweb3.s3.conf.S3Config;
import com.opzpy123.zweb3.s3.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service("s3Service")
public class S3ServiceImpl implements S3Service {
    @Autowired
    AmazonS3 amazonS3;
    @Autowired
    S3Config s3Config;

    public String createFile(byte[] fileContent) {
        if (fileContent == null) {
            log.error("存储文件内容不能为空");
            return null;
        }
        String fileStorePath = getFileStorePath();
        try {
            ObjectMetadata objectMetadata = buildObjectMetadata(fileContent, fileStorePath);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileContent);
            amazonS3.putObject(getBucketName(), fileStorePath, byteArrayInputStream, objectMetadata);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileStorePath;
    }

    public byte[] getFile(String fileStorePath) {
        byte[] bytes = null;
        S3Object s3Object = amazonS3.getObject(getBucketName(), fileStorePath);
        try {
            bytes = IoUtil.readBytes(s3Object.getObjectContent());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                s3Object.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    private ObjectMetadata buildObjectMetadata(byte[] fileContent, String fileStorePath) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(fileContent.length);
        Map<String, String> userMetaDataMap = new HashMap<>();
        userMetaDataMap.put("file_store_path", fileStorePath);
        objectMetadata.setUserMetadata(userMetaDataMap);
        return objectMetadata;
    }

    private String getFileStorePath() {
        String fileStorePath = DateUtil.format(new Date(), "yyyyMM") + "/" + IdUtil.fastSimpleUUID();
        return fileStorePath;
    }

    private String getBucketName() {
        String bucketName = s3Config.getBucketName();
        return bucketName;
    }
}
