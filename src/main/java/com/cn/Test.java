package com.cn;

import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author zy
 * 2022/12/8  21:39
 */
public class Test {

    @SneakyThrows
    @Scheduled(cron = "0 0/1 * * * ?")
    public void threeD() {
        System.out.println("use floor:=" + Math.floor(Math.random() * 10));
        for (int i = 0; i < 3; i++){
            Thread.sleep(4);
            System.out.print("本次开奖号码： "+(int)Math.floor(Math.random()*10));
        }
    }

}
