package com.erbing.member.controller;

import com.erbing.member.common.MailUtil;
import com.erbing.member.common.MemberConstants;
import com.erbing.member.dto.MemberRegisterDTO;
import com.erbing.member.service.MemberService;
import com.erbing.util.commom.EmailUtil;
import com.erbing.util.exception.BizException;
import com.erbing.util.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.erbing.util.exception.CommonsConstants.SUCCESS;

/**
 * 会员管理controller
 */
@RequestMapping("/v1/member")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MailUtil mailUtil;
    /**
     * 用户注册
     * @param param
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseResult<Boolean> register(@RequestBody MemberRegisterDTO param){
        if(!EmailUtil.validateEmailFormat(param.getEmail())){
            throw  new BizException(MemberConstants.EMAIL_FORMAT_ERROR);
        }
        Boolean result =this.memberService.register(param);
        return  new ResponseResult<>(SUCCESS, result);
    }

    /**
     * 发送邮件
     * @param email
     * @param type
     * @return
     */
    @RequestMapping(value = "/sendEmailCode",method = RequestMethod.GET)
    public ResponseResult<Boolean> sendEmail(@RequestParam("email") String email,@RequestParam("type") Integer type){
        Boolean result =this.mailUtil.sendMail(email);
        return new ResponseResult<>(SUCCESS,result);
    }
}
