package com.lxt.scheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class QuartzSchedulerMain {

    public static void main(String[] args) {
        try{
            SpringApplication.run(QuartzSchedulerMain.class);
        } catch (Exception e){
            log.error("Error when start spring application!!!",e);
            return;
        }
        log.info("START SUCCESS!");
        return;
    }

}
