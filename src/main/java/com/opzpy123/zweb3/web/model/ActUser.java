package com.opzpy123.zweb3.web.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.opzpy123.zweb3.web.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("ACT_USER")
@EqualsAndHashCode(callSuper = true)
public class ActUser extends BaseModel {
    private String userName;
    private String userPassword;
}
