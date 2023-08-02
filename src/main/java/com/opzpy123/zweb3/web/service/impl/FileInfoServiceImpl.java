package com.opzpy123.zweb3.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.opzpy123.zweb3.web.mapper.FileInfoMapper;
import com.opzpy123.zweb3.web.model.FileInfo;
import com.opzpy123.zweb3.web.service.FileInfoService;
import org.springframework.stereotype.Service;

@Service("fileInfoService")
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements FileInfoService {
}
