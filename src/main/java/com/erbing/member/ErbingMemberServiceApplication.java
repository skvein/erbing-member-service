package com.erbing.member;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.erbing"},exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan("com.erbing.member.mapper")
public class ErbingMemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErbingMemberServiceApplication.class, args);
    }

}
