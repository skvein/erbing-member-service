package com.erbing.member.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MemberConfig {
    @Value("${member.email.from}")
    private String fromEmail;

    @Value("${member.email.authorization}")
    private String authorization;

}
