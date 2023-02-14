package com.opzpy123.zweb3.component.s3.conf;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(S3Properties.class)
public class S3Config {

    @Resource
    private S3Properties s3Properties;

    /**
     * 初始化s3客户端
     */
    @Bean
    public AmazonS3 s3Client() {
        ClientConfiguration conf = new com.amazonaws.ClientConfiguration();
        conf.setProtocol(Protocol.HTTP);

        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(s3Properties.getEndpoint(), s3Properties.getRegion());
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(s3Properties.getAccessKey(), s3Properties.getSecretKey());

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withClientConfiguration(conf)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withEndpointConfiguration(endpointConfiguration)
                .build();
        checkAndCreateBucket(s3Client);
        return s3Client;
    }

    /**
     * 检查桶是否存在，不存在则创建创建
     *
     * @param s3Client s3Client
     */
    private void checkAndCreateBucket(AmazonS3 s3Client) {
        boolean exists = s3Client.doesBucketExistV2(getBucketName());
        if (!exists) {
            CreateBucketRequest request = new CreateBucketRequest(getBucketName());
            s3Client.createBucket(request);
        }
    }

    /**
     * 获取存储桶名称
     */
    public String getBucketName() {
        return s3Properties.getBucketName();
    }
}