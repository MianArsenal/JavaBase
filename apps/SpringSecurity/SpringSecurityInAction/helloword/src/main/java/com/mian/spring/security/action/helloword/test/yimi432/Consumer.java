package com.mian.spring.security.action.helloword.test.yimi432;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Consumer implements Runnable {
    private List<Data> queue;

    public Consumer(List<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.notifyAll();
                        queue.wait();
                    }
                    Data data = queue.remove(0);
                    final CountDownLatch latch = new CountDownLatch(5);
                    for (int i = 0; i < 5; i++) {
                        new Thread(() -> {
                            System.out.println(Thread.currentThread().getId());
                            latch.countDown();
                        }).start();
                    }
                    latch.await();
                    System.out.println("Consumed data with time = " + data.getTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
