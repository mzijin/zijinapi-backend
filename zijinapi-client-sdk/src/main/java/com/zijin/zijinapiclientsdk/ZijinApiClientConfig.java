package com.zijin.zijinapiclientsdk;

import com.zijin.zijinapiclientsdk.client.ZijinapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//增加接口的前缀
@ConfigurationProperties("client")
@Data
@ComponentScan
public class ZijinApiClientConfig {
    private String accessKey;
    private String secretKey;
    @Bean
    public ZijinapiClient zijinapiClient(){
        return new ZijinapiClient(accessKey,secretKey);


    }

}
