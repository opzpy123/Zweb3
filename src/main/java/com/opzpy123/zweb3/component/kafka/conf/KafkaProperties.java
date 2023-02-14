package com.opzpy123.zweb3.component.kafka.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
    private String bootstrapServers;
    private Integer concurrency;    //并发数 小于或等于分区数
    private ProducerProperties producer = new ProducerProperties();
    private ConsumerProperties consumer = new ConsumerProperties();

    @Data
    public class ProducerProperties {
        private String retries;
        private String batchSize;
        private String bufferMemory;
    }

    @Data
    public class ConsumerProperties {
        private String groupId;
        private String autoOffsetReset;
        private String enableAutoCommit;
        private String maxPollRecords;
        private String autoCommitInterval;
    }
}
