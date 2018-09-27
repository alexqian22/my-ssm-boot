package com.enreach.ssm.conf;

import com.enreach.ssm.utils.concurrent.ThreadPoolBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class TaskPoolConfig {

    /**
     * 设定async的线程池
     *
     * @return
     */
    @Bean("taskPool")
    public Executor executor() {

        return ThreadPoolBuilder.queuableCachedPool()
                .setMaxSize(20).setQueueSize(100).setKeepAliveSecs(30).setThreadNamePrefix("task-enreach")
                .setRejectHanlder(new ThreadPoolExecutor.AbortPolicy()).build();

    }

}
