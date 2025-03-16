package com.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
// 通过prefix属性来指定配置参数项的前缀(对应application.yml中的前缀)
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {

    private String endpoint;
    private String bucketName;

}
