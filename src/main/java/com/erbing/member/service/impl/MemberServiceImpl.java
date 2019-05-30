package com.erbing.member.service.impl;

import com.alibaba.fastjson.JSON;
import com.erbing.member.common.MemberConstants;
import com.erbing.member.dto.MemberRegisterDTO;
import com.erbing.member.mapper.MemberMapper;
import com.erbing.member.po.MbUser;
import com.erbing.member.service.MemberService;
import com.erbing.util.commom.Fence;
import com.erbing.util.exception.BizException;
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
        //验证邮箱是否存在
        MbUser user =this.memberMapper.selectByEmail(param.getEmail());
        if(user !=null){
            throw  new BizException(MemberConstants.USER_EXISTS);
        }
        //密码加密
        param.setPassWord(Fence.encryption(param.getPassWord()));
        Long memberId=memberMapper.insert(param);
        return memberId !=null;
    }
}
