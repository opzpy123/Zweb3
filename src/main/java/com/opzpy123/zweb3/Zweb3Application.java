package com.opzpy123.zweb3;

import com.opzpy123.zweb3.component.kafka.conf.KafkaConf;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@MapperScan("com.opzpy123.zweb3.web.mapper")
public class Zweb3Application {

    public static void main(String[] args) {
        SpringApplication.run(Zweb3Application.class, args);
    }

    //启动时自动执行 参数可以是任何bean
    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send(KafkaConf.topic, "hello kafka");
        };
    }
}
