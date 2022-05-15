package com.lxt.lab.fuckzhian;

import com.lxt.lab.fuckzhian.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


public class FuckZhiAn {
    private static final Logger log = LoggerFactory.getLogger(FuckZhiAn.class);

    public static void main(String[] args) {

//        String moduleName = "BSS_BS1_TNNT_YWB";
        if (args.length == 0 || args[0].length() == 0) {
            log.error("请传入参数： 模块名");
            return;
        }

        String moduleName = args[0];
        String authorizationMessage = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjQxMDIzNTg0MDAsInVzZXJuYW1lIjoieHRsaSJ9.0MP6sVcBX0PQ0R2RV-Vx8FrkuNoHOgD5utvruY3WDfI";

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://172.21.33.197:18888/srdp/comp")
                .additionalInterceptors((request, body, execution) -> {
                    request.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
                    request.getHeaders().set("Authorization", authorizationMessage);
                    return execution.execute(request, body);
                })
                .build();

        VulResult vulResult = restTemplate.getForObject("/confirmVul?moduleName=" + moduleName, VulResult.class);

        if (!"0000".equals(vulResult.getCode())) {
            log.error("查询漏洞失败，code：{}",vulResult.getCode());
            return;
        }

        if (vulResult!=null && vulResult.getData()!=null && vulResult.getData().size()!=0) {
            log.info("查到漏洞数："+vulResult.getData().size());
            List<VulProcessItem> vulProcessItems = vulResult.getData().stream().map(vulItem -> {
                VulProcessItem vulProcessItem = new VulProcessItem();
                vulProcessItem.setAffected("0");
                vulProcessItem.setFilePath(vulItem.getFilePath());
                vulProcessItem.setModName(moduleName);
                vulProcessItem.setRemark("不受影响：不对外提供服务");
                vulProcessItem.setVulnerNm(vulItem.getVulnerNm());
                return vulProcessItem;
            }).collect(Collectors.toList());

            VulProcessRequest vulProcessRequest = new VulProcessRequest();
            vulProcessRequest.setVulners(vulProcessItems);

            VulProcessResult vulProcessResult = restTemplate.postForObject("/vulSubmit", vulProcessRequest, VulProcessResult.class);

            if (!"0000".equals(vulProcessResult.getCode())) {
                log.error("处理漏洞失败，code：{}",vulProcessResult.getCode());
                return;
            } else {
                log.info("处理漏洞成功，全置为不受影响！");
                return;
            }
        } else {
            log.warn("查询漏洞成功，但该模块无漏洞");
            return;
        }
    }

}
