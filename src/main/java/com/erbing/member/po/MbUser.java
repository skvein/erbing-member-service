package com.erbing.member.po;

import lombok.Data;

@Data
public class MbUser {
    private Long id;
    private String phone;
    private String profession;
    private String name;
    private String email;
    private String password;
    private Integer status;
}
