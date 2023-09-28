package com.opzpy123.zweb3.web.controller;

import com.opzpy123.zweb3.component.kafka.conf.KafkaConf;
import com.opzpy123.zweb3.core.vo.req.StringReq;
import com.opzpy123.zweb3.core.vo.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <b>注意：该路由下没有权限校验</b>
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    protected KafkaTemplate<String,Object> kafkaTemplate;

    @PostMapping("test")
    public R<String> test(@RequestBody StringReq req) {
        HashMap<String, String> map = new HashMap<>();
        map.put("","");
        kafkaTemplate.send(KafkaConf.topic,"hhhhe");
        return R.success("success");
    }
}
