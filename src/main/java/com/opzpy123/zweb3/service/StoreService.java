package com.opzpy123.zweb3.service;

import com.opzpy123.zweb3.model.FileInfo;

public interface StoreService {

    /**
     * 创建文件信息及存储文件内容
     *
     * @param fileName        文件名
     * @param fileDescription 文件描述
     * @param content         内容
     * @return 存储信息
     */
    FileInfo doCreateFile(String fileName, String fileDescription, Object content);

    /**
     * 加载文件信息
     *
     * @param fileInfoId 存储信息id
     * @return 存储信息
     */
    FileInfo doLoadFileInfo(String fileInfoId);

    /**
     * 加载存储文件内容
     *
     * @param fileStorePath 文件内容存储urlPath
     * @return 反序列化对象
     */
    Object doLoadFileData(String fileStorePath);
}
