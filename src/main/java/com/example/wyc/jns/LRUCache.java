package com.example.wyc.jns;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * 缓存容量
     */
    private int maxEntries;

    /**
     * 构造器
     *
     * @param maxEntries 最大容量
     */
    LRUCache(Integer maxEntries) {
        //调用父类构造器
        super(maxEntries, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        //如果节点数量大于LRU缓存容量，那么返回true
        return size() > maxEntries;
    }


    public static void main(String[] args) {

        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        for (int i = 0; i < 10; i++) {
            cache.put(i, i * i);
        }
        System.out.println("after 10 times ，cache content======>");
        System.out.println(cache + "\n");

        System.out.println("access index 7，cache content======>");
        cache.get(7);
        System.out.println(cache + "\n");

        System.out.println("access index 1，cache content======>");
        cache.get(1);
        System.out.println(cache + "\n");

        System.out.println("insert index 1，cache content======>");
        cache.put(1, 1);
        System.out.println(cache);

        System.out.println("delete index 6，cache content======>");
        cache.remove(6);
        System.out.println(cache);

        System.out.println("insert index 7，cache content======>");
        cache.put(7, 7);
        System.out.println(cache);

    }

}
