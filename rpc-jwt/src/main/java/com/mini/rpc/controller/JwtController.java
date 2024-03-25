package com.mini.rpc.controller;

import com.mini.rpc.mapper.roleMapper;
import com.mini.rpc.service.impl.JwtTokenServiceImpl;
import com.nimbusds.jose.JOSEException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class JwtController {

    @Autowired
    private JwtTokenServiceImpl jwtTokenService;
    @Autowired
    private roleMapper rolemapper;

    private final static String secret = "rpc-mini";
    public boolean verifyByUser(String name, String psw) {
        String s = rolemapper.queryPwd(name);
        if (s == null) {
            log.error("没有此用户或账户失效！");
            return false;
        } else if (!s.equals(psw)) {
            log.error("密码错误请重新输入！");
            return false;
        } else {
            return true;
        }
    }

    public String getToken(String name,String psw) throws JOSEException {
        if (verifyByUser(name, psw)) {
            return jwtTokenService.getTokenByHMAC(jwtTokenService.getDefaultPayloadDto(name).toString(), secret);
        } else {
            return null;
        }
    }
}