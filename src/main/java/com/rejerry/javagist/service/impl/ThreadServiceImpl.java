package com.rejerry.javagist.service.impl;

import com.rejerry.javagist.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@Service
public class ThreadServiceImpl implements ThreadService, InitializingBean, DisposableBean {
    private ExecutorService service;

    private static final long TIME = 100;
    private static final long TIME_OUT_1 = 100L;
    private static final long TIME_OUT_2 = 200L;
    private static final long TIME_OUT_600 = 60000L;


    @Override
    public void destroy() {
        service.shutdown();
    }

    @Override
    public void afterPropertiesSet() {
        service = new ThreadPoolExecutor(20, 50, 60L
                , TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private boolean doExecute() {
        try {
            Thread.sleep(TIME_OUT_1);
        } catch (InterruptedException e) {

        }
        double random1 = Math.random();
        if (random1 > 0.7 && random1 < 0.8) {
            log.info("random1: {} exception", random1);
            String a = null;
            a.length();
        } else if (random1 >= 0.8) {
            try {
                log.info("sleep {} ms", TIME_OUT_2);
                Thread.sleep(TIME_OUT_2);
            } catch (InterruptedException e) {
                log.info("sleep {} ms exception", TIME_OUT_2, e);
            }
        } else {
            log.info("free: {} normal", random1);
        }
        return true;
    }


    @Override
    public boolean getData() {
        List<FutureTask> futureTasks = new ArrayList<>();
        for (int i = 0; i < TIME; i++) {
            FutureTask futureTask = new FutureTask(this::doExecute);
            futureTasks.add(futureTask);
            service.submit(futureTask);
        }

        for (FutureTask futureTask : futureTasks) {
            try {
                futureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                log.info("测试异常", e);
            }
        }
        return false;
    }


    @Override
    public boolean getDataTimeOutFillQueue() {
        List<FutureTask> futureTasks = new ArrayList<>();
        for (int i = 0; i < TIME; i++) {
            FutureTask futureTask = new FutureTask(() -> {
                try {
                    Thread.sleep(TIME_OUT_600);
                } catch (InterruptedException e) {

                }
                return true;
            });
            futureTasks.add(futureTask);
            service.submit(futureTask);
        }

        for (FutureTask futureTask : futureTasks) {
            try {
                futureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                log.info("测试异常", e);
            }
        }
        return false;
    }

    @Override
    public boolean getDataHaveTimeOut() {
        StopWatch watch = new StopWatch();
        watch.start("test-timeout");
        List<FutureTask> futureTasks = new ArrayList<>();
        for (int i = 0; i < TIME; i++) {
            FutureTask futureTask = new FutureTask(() -> {
                try {
                    Thread.sleep(TIME_OUT_1);
                    return 1;
                } catch (InterruptedException e) {
                    return -1;
                }
            });
            futureTasks.add(futureTask);
            service.submit(futureTask);
        }

        List<Integer> successCount = new CopyOnWriteArrayList<>();
        for (FutureTask futureTask : futureTasks) {
            try {
                Integer data = (Integer) futureTask.get(TIME_OUT_2, TimeUnit.MILLISECONDS);
                if (data != null) {
                    successCount.add(data);
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
//                if (!futureTask.isDone() && !futureTask.isCancelled()) {
//                    futureTask.cancel(true);
//                }
                log.info("测试异常-有超时", e);
            }
        }
        watch.stop();
        double totalTimeSeconds = watch.getTotalTimeSeconds();
        log.info("totalTimeSeconds {}, successCount {}" + totalTimeSeconds, successCount);
        return false;
    }
}
