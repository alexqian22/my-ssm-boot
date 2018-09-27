package com.enreach.ssm.quartz;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class AsyncTask {

    public static Random random = new Random();

    @Async("taskPool")
    public Future<String> runTask() throws InterruptedException {
        long sleep = 2000;
        System.out.println("开始任务，需耗时：" + sleep + "毫秒");
        System.out.println("child:" + Thread.currentThread().getName());
        Thread.sleep(sleep);
        System.out.println("完成任务");
        return new AsyncResult<>("test");
    }

}
