package com.lxt.lab.sso.rely.party.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class ProtectedController {

    @RequestMapping("/knock")
    public Authentication protectedResource(){
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication class:{}", jwtAuthenticationToken); //Class: JwtAuthenticationToken

        Map<String, Object> tokenAttributes = jwtAuthenticationToken.getTokenAttributes();
        log.info("tokenAttributes:{}", tokenAttributes); //tokenAttributes Map 主要信息都在这里

        return jwtAuthenticationToken;
    }
}
