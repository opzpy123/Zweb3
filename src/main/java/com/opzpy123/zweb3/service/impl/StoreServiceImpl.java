package com.opzpy123.zweb3.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.opzpy123.zweb3.model.FileInfo;
import com.opzpy123.zweb3.s3.service.S3Service;
import com.opzpy123.zweb3.service.FileInfoService;
import com.opzpy123.zweb3.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("storeService")
public class StoreServiceImpl implements StoreService {
    @Autowired
    S3Service s3Service;
    @Autowired
    FileInfoService fileInfoService;

    public FileInfo doCreateFile(String fileName, String fileDescription, Object content) {
        if (StrUtil.isBlank(fileName)) {
            log.error("文件名不能为空");
            return null;
        }
        if (content == null) {
            log.error("文件内容不能为空");
            return null;
        }
        byte[] fileContent = ObjectUtil.serialize(content);
        String fileStorePath = s3Service.createFile(fileContent);
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setFileDescription(fileDescription);
        fileInfo.setFileStorePath(fileStorePath);
        fileInfoService.save(fileInfo);
        return fileInfo;
    }

    public FileInfo doLoadFileInfo(String fileInfoId) {
        if (StrUtil.isBlank(fileInfoId)) {
            log.error("文件信息id不能为空");
            return null;
        }
        FileInfo fileInfo = fileInfoService.getById(fileInfoId);
        return fileInfo;
    }

    public Object doLoadFileData(String fileStorePath) {
        if (StrUtil.isBlank(fileStorePath)) {
            log.error("文件存储位置不能为空");
            return null;
        }
        byte[] content = s3Service.getFile(fileStorePath);
        if (content == null || content.length == 0) {
            log.error("存储的文件信息不存在");
            return null;
        }
        Object object = ObjectUtil.deserialize(content);
        return object;
    }
}
