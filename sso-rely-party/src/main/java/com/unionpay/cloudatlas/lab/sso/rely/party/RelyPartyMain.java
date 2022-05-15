package com.lxt.lab.sso.rely.party;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class RelyPartyMain {

    public static void main(String[] args) {
        try{
            SpringApplication.run(RelyPartyMain.class);
        } catch (Exception e){
            log.error("Error when start spring application!!!",e);
            return;
        }
        log.info("START SUCCESS!");
        return;
    }

}
