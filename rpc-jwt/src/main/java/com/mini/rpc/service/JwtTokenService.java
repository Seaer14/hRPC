package com.mini.rpc.service;

import com.mini.rpc.common.Payload;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeyLengthException;

import java.text.ParseException;

public interface JwtTokenService {
    String getTokenByHMAC(String payload, String secret) throws KeyLengthException, JOSEException;

    Payload verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException;

    Payload getDefaultPayloadDto(String name);
}
