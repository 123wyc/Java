package com.example.wyc.redis.dealyQueue;

import redis.clients.jedis.Jedis;

/**
 * @author pc
 * @title: Main
 * @projectName wyc
 * @description: TODO
 * @date 2022/8/2223:37
 */
public class Main {
    public static void main(String[] args) {

        Jedis jedis = new Jedis();
        RedisDelayingQueue queue = new RedisDelayingQueue<>(jedis, "q-demo");
        Thread producer = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.delay("codehole" + i);
                }
            }
        };
        Thread consumer = new Thread() {
            public void run() {
                queue.loop();
            }
        };
        producer.start();
        consumer.start();
        try {
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        }
        catch (InterruptedException e) {
        }
    }
}
