package com.mini.rpc.consumer.controller;

import com.mini.rpc.consumer.annotation.RpcReference;
import com.mini.rpc.controller.JwtController;
import com.mini.rpc.provider.facade.HelloFacade;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan(value="com.mini.rpc")
public class HelloController {

    @Autowired
    private JwtController jwtController;
    private static String tokenJwt ;
    @PostMapping("/login")
    private String login(@RequestParam String name, @RequestParam String pwd) throws JOSEException {
        String res = jwtController.getToken(name, pwd);
        if (res == null) {
            return "登录失败请重试";
        } else {
            return "登录成功请继续";
        }
    }

    @SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpringJavaInjectionPointsAutowiringInspection"})
    @RpcReference(serviceVersion = "1.0.0", timeout = 3000)
    private HelloFacade helloFacade;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return helloFacade.hello("mini rpc");
    }
}
