package com.rejerry.javagist.util;

import org.springframework.util.StopWatch;

public class StopWatchTest2 {

    public static void main(String[] args) throws InterruptedException {
        testSpringStopWatch();
    }

    private static void testSpringStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("spring.stopWathc.learn");
        System.out.println("stopWatch.currentTaskName() = " + stopWatch.currentTaskName());
        stopWatch.start("first.task");
        Thread.sleep(200L);
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("stopWatch.getTotalTimeMillis() = " + totalTimeMillis);
        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());
        stopWatch.start("first.task.v2");
        Thread.sleep(100L);
        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeMillis() = " + totalTimeMillis);
        System.out.println("stopWatch.getLastTaskTimeMillis() = " + stopWatch.getLastTaskTimeMillis());
        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());
    }
}
