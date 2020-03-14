package com.example.wyc.common.threadLocal;

public class ThreadLocalTest {

    private static String strLabel;
    private static ThreadLocal<String> threadLabel = new ThreadLocal<>();


    /**
     * 主线程中，在threalLocal<String>中预设了一个值</>
     * 在子线程中修改threalLocal的值，等待子线程运行结束
     * 在主线程中获取 threalLocal 的值，值未变
     * Result：在一个线程中设置值，不影响其在其它线程中的值。也就是说 ThreadLocal 类型的变量的值在每个线程中是独立的。
     * @param args
     */
    public static void main(String... args) {
        strLabel = "main";
        threadLabel.set("main");
        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();
                strLabel = "child";
                threadLabel.set("child");
            }

        };
        thread.start();

        try {
            // 保证线程执行完毕
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("strLabel = " + strLabel);
        System.out.println("threadLabel = " + threadLabel.get());
    }
}
/**
 *  treadLocal  源码理解
 *
 *  // 存储数据的哈希表
 *      private Entry[] table;
 *     table 是一个 Entry 类型的数组，Entry 是 ThreadLocalMap 的一个内部类。
 *
 *     static class Entry extends WeakReference<ThreadLocal<?>> {
     *     Object value;
     *
     *     Entry(ThreadLocal<?> k, Object v) {
     *         super(k);
     *         value = v;
     *     }
 * }
 *假设 Entry 的 key 没有使用弱引用的方式，而是使用了强引用：
 * 由于 ThreadLocalMap 的生命周期和当前线程一样长，那么当引用 ThreadLocal 的对象被回收后，
 * 由于 ThreadLocalMap 还持有 ThreadLocal 和对应 value 的强引用，ThreadLocal 和对应的 value 是不会被回收的，
 * 这就导致了内存泄漏。所以 Entry 以弱引用的方式避免了 ThreadLocal 没有被回收而导致的内存泄漏，但是此时 value 仍然是无法回收的，依然会导致内存泄漏。
 *ThreadLocalMap 已经考虑到这种情况，并且有一些防护措施：
 * 在调用 ThreadLocal 的 get()，set() 和 remove() 的时候都会清除当前线程
 * ThreadLocalMap 中所有 key 为 null 的 value。这样可以降低内存泄漏发生的概率。
 * 所以我们在使用 ThreadLocal 的时候，每次用完 ThreadLocal 都调用 remove() 方法，清除数据，防止内存泄漏。
*
 *          ThreadLocalMap m = getMap(Thread.currentThread());
 *          if (m != null)
 *              m.remove(this);
 *      }
 *
 */





