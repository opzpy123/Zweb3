package com.opzpy123.zweb3.component.s3.service;

/**
 * 存储功能抽象接口
 */
public interface S3Service {

    /**
     * 创建文件
     *
     * @param fileContent 文件内容
     * @return 文件存储位置key
     */
    String createFile(byte[] fileContent);

    /**
     * 获取文件
     *
     * @param fileStorePath 文件存储位置key
     * @return 文件内容
     */
    byte[] getFile(String fileStorePath);
}
