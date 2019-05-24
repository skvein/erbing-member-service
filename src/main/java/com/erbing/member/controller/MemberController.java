package com.erbing.member.controller;

import com.erbing.member.dto.MemberRegisterDTO;
import com.erbing.member.service.MemberService;
import com.erbing.util.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.erbing.util.exception.CommonsConstants.SUCCESS;

/**
 * 会员管理controller
 */
@RequestMapping("/v1/member")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 用户注册
     * @param param
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseResult<Boolean> register(@RequestBody MemberRegisterDTO param){
        Boolean result =this.memberService.register(param);
        return  new ResponseResult<>(SUCCESS, result);
    }
}
