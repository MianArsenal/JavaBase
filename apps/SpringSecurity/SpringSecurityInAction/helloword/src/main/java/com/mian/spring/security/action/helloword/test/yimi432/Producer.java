package com.mian.spring.security.action.helloword.test.yimi432;

import java.util.List;

public class Producer implements Runnable {
    private List<Data> queue;

    public Producer(List<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Data data = new Data();
                data.setTime(System.currentTimeMillis());
                System.out.println("produce data with time = " + data.getTime());
                synchronized (queue) {
                    queue.add(data);
                    queue.notifyAll();
                    queue.wait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
