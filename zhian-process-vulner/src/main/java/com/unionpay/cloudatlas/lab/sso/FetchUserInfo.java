package com.lxt.lab.sso;

import com.lxt.lab.sso.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


public class FetchUserInfo {
    private static final Logger log = LoggerFactory.getLogger(FetchUserInfo.class);

    public static void main(String[] args) {

//        String moduleName = "BSS_BS1_TNNT_YWB";
        if (args.length == 0 || args[0].length() == 0) {
            log.error("请传入参数： access_token");
            return;
        }

        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjNGOTg4Q0UwNUUzNTI1ODUxODYwNTZDNzZCMDk5ODNFQkY5NjNEOTMiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJQNWlNNEY0MUpZVVlZRmJIYXdtWVByLVdQWk0ifQ.eyJuYmYiOjE2MzAwNDczMDUsImV4cCI6MTYzMDA1NDUwNSwiaXNzIjoiaHR0cHM6Ly90ZWNocG9ydGFsLm9hLnVuaW9ucGF5LmNvbSIsImF1ZCI6WyJodHRwczovL3RlY2hwb3J0YWwub2EudW5pb25wYXkuY29tL3Jlc291cmNlcyIsImRldl9jZW50ZXJfYXBpIiwiY2hpdHVfYXBpIl0sImNsaWVudF9pZCI6ImRldl9jZW50ZXIiLCJzdWIiOiJ4dGxpIiwiYXV0aF90aW1lIjoxNjMwMDQ3MzAyLCJpZHAiOiJsb2NhbCIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJkZXZfY2VudGVyX2FwaSIsImNoaXR1X2FwaSJdLCJhbXIiOlsicHdkIl19.JdsZQ2AGCKImtVZngLNRV1hKQSF4iDmSg13h-HpGem8QWOMKoCwNDao5I_bNzNw_PeLJyT86fVuuVbFwVkbG6AbQu8m87W5H37Zk8cDVCpz37CS6uvxs9FUhbshBxnmTctSt6AKC5drizOskn9OVcZ3THc3mVw_XoB_Xbb0Gub8SDtaP2P76uUfqK40xRZBpxNot5hvz381g5lLyn5495W1yYrFUJkocQnjRBpg2dYhK6mgz-9S7looUDGVL-aWSKyPBgaBgiPSilsch3HHlCcrlTS1s1s0q6MzcAMScUZOIRckqfsoobJZ6o9mZ3XQq3cCu26xwPFZpfDK9vgWGgg";
        log.info("access_token为：{}",accessToken);

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("https://techportal.oa.lxt.com/connect")
                .additionalInterceptors((request, body, execution) -> {
                    request.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
                    request.getHeaders().set("Authorization", accessToken);
                    return execution.execute(request, body);
                })
                .build();

        ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.getForEntity("/userinfo", UserInfo.class);

        log.info("用户信息为{}",userInfoResponseEntity);
    }

}
