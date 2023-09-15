package com.example.wyc.common.threadLocal;

/**
 * treadLocal  源码理解
 * <p>
 * 存储数据的哈希表
 * private Entry[] table;
 * table 是一个 Entry 类型的数组，Entry 是 ThreadLocalMap 的一个内部类。
 * <p>
 * static class Entry extends WeakReference<ThreadLocal<?>> {
 * Object value;
 * <p>
 * Entry(ThreadLocal<?> k, Object v) {
 * super(k);
 * value = v;
 * }
 * }
 * 假设 Entry 的 key 没有使用弱引用的方式，而是使用了强引用：
 *  由于 ThreadLocalMap 的生命周期和当前线程一样长，那么当引用 ThreadLocal 的对象被回收后，
 * 由于 ThreadLocalMap 还持有 ThreadLocal 和对应 value 的强引用，ThreadLocal 和对应的 value 是不会被回收的，
 * 这就导致了内存泄漏。所以 Entry 以弱引用的方式避免了 ThreadLocal 没有被回收而导致的内存泄漏，
 * 但是此时 value 仍然是无法回收的，依然会导致内存泄漏。
 * ThreadLocalMap 已经考虑到这种情况，并且有一些防护措施：
 * 在调用 ThreadLocal 的 get()，set() 和 remove() 的时候都会清除当前线程 ThreadLocalMap 中所有 key 为 null 的 value。这样可以降低内存泄漏发生的概率。
 * 所以我们在使用 ThreadLocal 的时候，每次用完 ThreadLocal 都调用 remove() 方法，清除数据，防止内存泄漏。
 * <p>
 * ThreadLocalMap m = getMap(Thread.currentThread());
 * if (m != null)
 * m.remove(this);
 * }
 */





