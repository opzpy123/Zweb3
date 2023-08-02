package com.opzpy123.zweb3.controller;

import com.opzpy123.zweb3.component.kafka.conf.KafkaConf;
import com.opzpy123.zweb3.model.ActUser;
import com.opzpy123.zweb3.service.ActUserService;
import com.opzpy123.zweb3.vo.req.StringReq;
import com.opzpy123.zweb3.vo.resp.R;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>注意：该路由下没有校验</b>
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    protected KafkaTemplate<String,Object> kafkaTemplate;

    @PostMapping("test")
    public R<String> test(@RequestBody StringReq req) {
        kafkaTemplate.send(KafkaConf.topic,"hhhhe");
        return R.success("success");
    }
}
