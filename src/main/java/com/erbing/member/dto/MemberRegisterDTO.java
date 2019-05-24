package com.erbing.member.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 会员注册参数
 */
@Data
public class MemberRegisterDTO {
    private Long memberId;
    /**
     * 姓氏
     */
    @NotBlank
    private String lastName;
    /**
     * 名字
     */
    @NotBlank
    private String firstName;

    /**
     * 邮箱
     */
    @NotBlank
    private String  email;

    /**
     * 登陆密码
     */
    @NotBlank
    private String passWord;
}
