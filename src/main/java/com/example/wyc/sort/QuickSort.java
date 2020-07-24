package com.example.wyc.sort;

/**
 * @author wyc
 * @date 2020/7/17/17:54
 */
public class QuickSort {



    public static void quickSort(int[] a, int l, int r) {


        if (l < r) {
            int i,j,x;

            i = l;
            j = r;
            x = a[i];

            while (i < j) {
                while(i < j && a[j] > x){
                    j--; // 从右向左找第一个小于x的数
                }

                if(i < j){
                    a[i++] = a[j];
                }

                while(i < j && a[i] < x){
                    i++; // 从左向右找第一个大于x的数
                }

                if(i < j){
                    a[j--] = a[i];
                }

            }
            a[i] = x;
        //10 20 30 60 40 50
            /* 递归调用 */
          quickSort(a, l, i-1);
            //10 20 30 60 40 50
            /* 递归调用 */
          quickSort(a, i+1, r);
          //10 20 30 40 50 60
        }

    }

        public static void main(String[] args) {

            int a[] = {30,40,60,10,20,50};
            quickSort(a, 0, a.length-1);


            System.out.printf("after  sort:");
            for (int i=0; i<a.length; i++){
                System.out.printf("%d ", a[i]);
            }

            System.out.printf("\n");
        }






}
