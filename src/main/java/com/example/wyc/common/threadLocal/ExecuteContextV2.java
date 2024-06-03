package com.example.wyc.common.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ExecuteContextV2 {

    private static AtomicInteger state = new AtomicInteger(0); // 初始状态为0，表示A线程准备打印
    private static final int TOTAL_PRINTS = 10; // 总打印次数

    public static void main(String[] args) {
        new Thread(new Printer('A', 0)).start();
        new Thread(new Printer('B', 1)).start();
        new Thread(new Printer('C', 2)).start();
    }

    static class Printer implements Runnable {
        private char toPrint;
        private int expectedState;

        public Printer(char toPrint, int expectedState) {
            this.toPrint = toPrint;
            this.expectedState = expectedState;
        }

        @Override
        public void run() {
            for (int i = 0; i < TOTAL_PRINTS; ) {
                while (state.get() % 3 != expectedState) {
                    // 自旋等待，直到状态匹配
                }
                // 状态匹配，打印字符并更新状态
                System.out.print(toPrint);
                i++;
                state.incrementAndGet(); // CAS操作，原子性地增加状态
                if (toPrint == 'C') {
                    System.out.println(); // 每打印完一轮C后换行
                }
                // 休眠模拟打印间隔，实际应用中可能不需要
                try {
                    Thread.sleep(100); // 确保打印顺序可见
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}