package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${avatarPath}")
    private String avatarPath;

    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("index")
    public String index(){
        return "你好啊！";
    }

    @GetMapping("change")
    public String change(){
        return avatarPath;
    }

    @GetMapping("log")
    public String log(){
        log.error("HelloController-log,测试日志");
        log.warn("HelloController-log,测试日志");
        log.info("HelloController-log,测试日志");
        log.debug("HelloController-log,测试日志");
        log.trace("HelloController-log,测试日志");
        return "success";
    }

}
