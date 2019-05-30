package com.erbing.member.common;

import com.erbing.util.exception.BizCode;

public interface MemberConstants {

    /***************** 系统级错误码 200000  *****************/
    BizCode EMAIL_FORMAT_ERROR = new BizCode("200001", "邮箱格式错误");
    BizCode USER_EXISTS = new BizCode("200002", "用户已存在");
    BizCode SEND_EMAIL_ERROR = new BizCode("200003", "用户已存在");
}
