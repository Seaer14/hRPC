package com.mini.rpc.exception;

public class JwtInvalidExcption extends RuntimeException {
    public JwtInvalidExcption(String msg) {
        super(msg);
    }
}
