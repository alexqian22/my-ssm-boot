package com.enreach.ssm.async;

import com.enreach.ssm.Application;
import com.enreach.ssm.quartz.AsyncTask;
import com.enreach.ssm.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskTest {

    @Autowired
    private AsyncTask task;

    @Test
    public void test() throws Exception {
        Future<String> futureResult = task.runTask();
        System.out.println("main:" + Thread.currentThread().getName());

        String result = futureResult.get(5, TimeUnit.SECONDS);
        System.out.println(result);
    }


}
