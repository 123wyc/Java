package com.example.wyc.common.threadLocal;

public class ExecuteContext {
    private int state; // 状态标志，0-A, 1-B, 2-C
    private final Object lock = new Object();

    class ThreadA implements Runnable {
        @Override
        public void run() {
            print("A", 0);
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            print("B", 1);
        }
    }

    class ThreadC implements Runnable {
        @Override
        public void run() {
            print("C", 2);
        }
    }

    // 打印方法
    private void print(String name, int targetState) {

        for (int i = 0; i < 10; ) { // 控制打印次数

            synchronized (lock) {

                while (state % 3 != targetState) { // 不是当前线程的打印时机就等待
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++; // 更新状态，准备唤醒下一个线程
                i++; // 增加计数，表示已经打印了一次
                System.out.print(name);
                lock.notifyAll(); // 唤醒其他等待的线程
            }
            if (name.equals("C")) { // 每打印完一轮C，换行
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        ExecuteContext printInOrder = new ExecuteContext();
        new Thread(printInOrder.new ThreadA()).start();
       new Thread(printInOrder.new ThreadB()).start();
        new Thread(printInOrder.new ThreadC()).start();
    }
}