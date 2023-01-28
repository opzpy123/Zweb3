package com.opzpy123.zweb3.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.opzpy123.zweb3.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("FILE_INFO")
@EqualsAndHashCode(callSuper = true)
public class FileInfo extends BaseModel {
    private String fileName;
    private String fileDescription;
    private String fileStorePath;
}
