package com.opzpy123.zweb3.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.opzpy123.zweb3.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("ACT_USER")
@EqualsAndHashCode(callSuper = true)
public class ActUser extends BaseModel {
    private String userName;
    private String userPassword;
}
