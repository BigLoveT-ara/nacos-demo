package org.yhsu.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("echo")
@RefreshScope
public class EchoController {

    @Value("${double-return:false}")
    private boolean doubleReturn;

    @GetMapping("/{msg}")
    public String echo(@PathVariable String msg) {
        if (doubleReturn) {
            return "Hello " + msg + msg;
        }
        return "Hello " + msg;
    }
}
