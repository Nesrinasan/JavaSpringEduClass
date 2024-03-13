package com.robotdreams.JavaSpringEduClass.concurrency.concurrentProcessing;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker implements Runnable {
    private int sharedCounter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increaseCounter();
        }
    }

    private void increaseCounter() {
        sharedCounter++;
        System.out.println("Thread " + Thread.currentThread().getId() + " increased counter to " + sharedCounter);
    }
}
