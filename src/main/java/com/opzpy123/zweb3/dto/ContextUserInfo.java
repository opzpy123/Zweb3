package com.opzpy123.zweb3.dto;

import com.opzpy123.zweb3.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContextUserInfo extends BaseModel {
    private String userName;
}
