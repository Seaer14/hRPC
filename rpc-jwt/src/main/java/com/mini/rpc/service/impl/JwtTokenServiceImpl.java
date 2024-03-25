package com.mini.rpc.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.mini.rpc.exception.JwtExpiredExcption;
import com.mini.rpc.exception.JwtInvalidExcption;
import com.mini.rpc.service.JwtTokenService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    @Override
    public String getTokenByHMAC(String payloadStr, String secret) throws JOSEException {
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();
        com.nimbusds.jose.Payload payload = new com.nimbusds.jose.Payload(payloadStr);
        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //创建签名
        JWSSigner jwsSigner = new MACSigner(secret);
        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }

    @Override
    public com.mini.rpc.common.Payload verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(token);
        //创建HMAC验证器
        JWSVerifier jwsVerifier = new MACVerifier(secret);
        if (!jwsObject.verify(jwsVerifier)) {
            throw new JwtInvalidExcption("token签名不合法!");
        }
        String payload = jwsObject.getPayload().toString();
        com.mini.rpc.common.Payload payloadDto = JSONUtil.toBean(payload, com.mini.rpc.common.Payload.class);
        if (payloadDto.getEt() < new Date().getTime()) {
            throw new JwtExpiredExcption("token已过期!请重新登录");
        }
        return payloadDto;
    }

    @Override
    public com.mini.rpc.common.Payload getDefaultPayloadDto(String name) {
        Date now = new Date();
        Date exp = DateUtil.offsetSecond(now, 60 * 60 * 3);
        return com.mini.rpc.common.Payload.builder().sub("rpc")
                .st(now.getTime())
                .et(exp.getTime())
                .id(UUID.randomUUID().toString())
                .username(name)
                .build();
    }
}
