package com.example.wyc.dataStructure.heap;

public class Heap {

    private int count; //已经存储的数字
    private int[] items; //堆的数据
    private int n; //可以存储的最大数


    public Heap(int capacity) {
        this.n = capacity;
        this.items = new int[capacity + 1];
        count = 0;
    }

    //模拟大堆
    public void insert(int data) {

        if (count >= n) {
            return;//满了
        }
        count++;
        items[n + 1] = data;

        int i = count;
        while (i / 2 > 0 && items[i / 2] < items[i]) {
            swap(items,items[i/2],items[i]);
            i = i/2;
        }
    }

    private int[] swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
        return items;
    }
}
