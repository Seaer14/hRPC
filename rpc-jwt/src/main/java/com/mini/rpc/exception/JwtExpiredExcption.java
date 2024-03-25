package com.mini.rpc.exception;

public class JwtExpiredExcption extends RuntimeException {
    public JwtExpiredExcption(String msg) {
        super(msg);
    }
}
