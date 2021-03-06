package com.enreach.ssm.utils;

import com.enreach.ssm.Application;
import com.enreach.ssm.infrastructure.cache.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {


    @Autowired
    private RedisCache redisCache;

    @Test
    public void setAndGet() {

        String str = "hello world";
        boolean put = redisCache.putCache("hello", str);

        String result = redisCache.getCache("hello", String.class);
        System.out.println(result);

    }

}
