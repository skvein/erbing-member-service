package com.erbing.member.mapper;

import com.erbing.member.dto.MemberRegisterDTO;
import com.erbing.member.po.MbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Long insert(MemberRegisterDTO param);

    MbUser selectByEmail(String email);
}
