package com.mini.rpc.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Payload { //用于封装JWT payload里储存的信息
    private String sub; //主题
    private Long st; //开始时间
    private Long et;  //过期时间
    private String id;
    private String username; //用户名
}
