package com.opzpy123.zweb3.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("ACT_USER")
public class ActUser implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String userName;
    private String userPassword;
}
