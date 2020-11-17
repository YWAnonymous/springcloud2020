package com.zhou.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        log.debug("******result" + serverPort + configInfo);
        return configInfo;
    }

}
