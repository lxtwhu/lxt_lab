package com.lxt.lab.sso.rely.party;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import sun.misc.URLClassPath;
import sun.net.www.ParseUtil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@Slf4j
public class TestURLClassLoader {
    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();


        String[] paths = {
                "classpath:org/springframework/util//AntPathMatcher.class",
                "classpath:com.lxt/lab/sso/rely/party/config//SsoSecurityConfig.class",
                "classpath:org/springframework/util/AntPathMatcher.class",
                "classpath:com.lxt/lab/sso/rely/party/config/SsoSecurityConfig.class"
        };

        for (String path: paths) {
            try {
                log.info(path);

                Resource resource = pathMatchingResourcePatternResolver.getResource(path);
                log.info(resource.getDescription());
                log.info(resource.getFilename());
                log.info(String.valueOf(resource.exists()));
                log.info(resource.getURL().toString());

            } catch (IOException e) {
                log.error(path+" resolve exception",e);
            }

        }




    }

}
