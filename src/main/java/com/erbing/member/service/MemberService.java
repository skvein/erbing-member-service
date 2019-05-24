package com.erbing.member.service;

import com.erbing.member.dto.MemberRegisterDTO;

/**
 * 会员管理接口类
 */
public interface MemberService {
    Boolean register(MemberRegisterDTO param);
}
