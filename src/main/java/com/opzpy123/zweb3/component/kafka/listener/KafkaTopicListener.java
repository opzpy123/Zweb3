package com.opzpy123.zweb3.component.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaTopicListener {
    private static final String topic = "web3Topic";

    @KafkaListener(topics = {topic}, containerFactory = "batchFactory")
    public void onMessage(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {
        long start = System.currentTimeMillis();
        for (ConsumerRecord<?, ?> record : records) {
            log.info("kafka接收到数据:key={},value={}", record.key(), record.value());
        }
        ack.acknowledge();
        log.info("收到批量推送的数据，拉取数据量：{}，消费时间：{}ms", records.size(), (System.currentTimeMillis() - start));
    }
}
