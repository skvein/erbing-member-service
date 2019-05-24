package com.erbing.member.service.impl;

import com.alibaba.fastjson.JSON;
import com.erbing.member.mapper.MemberMapper;
import com.erbing.member.dto.MemberRegisterDTO;
import com.erbing.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理接口实现
 */
@Slf4j
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;
    /**
     * 会员注册
     * @param param
     * @return
     */
    @Override
    public Boolean register(MemberRegisterDTO param) {
        //请求参数
        log.info(JSON.toJSONString(param));
        Long memberId=memberMapper.insert(param);
        return memberId !=null;
    }
}
