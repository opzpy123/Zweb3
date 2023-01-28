package com.opzpy123.zweb3.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.opzpy123.zweb3.dto.ContextUserInfo;
import com.opzpy123.zweb3.utils.AppContext;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@Configuration
@EnableTransactionManagement
@MapperScan("com.csx.demo.spring.boot.dao")
public class MyBatisPlusConfig {

    @Component
    public class MyFillHandler implements MetaObjectHandler {

        @Override
        public void insertFill(MetaObject metaObject) {
            this.strictInsertFill(metaObject, "createDate", Date.class, new Date());
            ContextUserInfo userInfo = AppContext.getUserInfo();
            if (userInfo != null) {
                this.strictInsertFill(metaObject, "createdBy", String.class, userInfo.getUserName());

            }
        }

        @Override
        public void updateFill(MetaObject metaObject) {
            this.strictUpdateFill(metaObject, "updateDate", Date.class, new Date());
            ContextUserInfo userInfo = AppContext.getUserInfo();
            if (userInfo != null) {
                this.strictUpdateFill(metaObject, "updatedBy", String.class, userInfo.getId());
            }
        }
    }
}
