package com.jnu.sortDemo;

import java.util.Arrays;

/**
 * Created by Damon on 2017/7/26.
 *
 * 直接插入排序
 *
 * 空间复杂度O(1) 　
 * 平均时间复杂度O(n^2)
 * 最差情况：反序，需要移动n*(n-1)/2个元素 ，运行时间为O(n^2)。
 * 最好情况：正序，不需要移动元素，运行时间为O(n)．
 * 属于内部排序，原理：从待排的数中选出一个元素，插入到已排序的合适位置。
 * 从带排序的数据中选出一个，插入到已排序的合适位置，显然耗时点在插入方面。在查找合适的位置，
 * 我们需要将带插入数据与已排序数据进行依次的对比找出合适的位置。
 *
 * 最优复杂度：当待排记录已经是有序是，复杂度为O(n)，而快速排序在这种情况在复杂度为O(n^2)
 * 最差复杂度：当待排记录倒序的时候，复杂度为O(n^2)
 *
 * 直接插入排序是，比较一个后移一个；
 * 折半插入排序是，先找到位置，然后一起移动；
 *
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        sort(arr);
    }

    private static void sort(int[] arr){
        int temp ;
        int flag;
        for(int i = 0; i < arr.length; i++){
            temp = arr[i];
            flag = i - 1;
            //内循环发现逆序不交换，采用整体右移，直到没有逆序的时候把元素放在该位置。
            while(flag >= 0 && temp < arr[flag]){
                arr[flag + 1] = arr[flag];
                flag --;
            }
            arr[flag + 1] = temp;
        }
    }

    /**
     * 折半插入排序
     * 折半插入排序,使用使用折半查找的方式寻找插入点的位置, 可以减少比较的次数,但移动的次数不变,
     * 时间复杂度和空间复杂度和直接插入排序一样，在元素较多的情况下能提高查找性能。
     * @param a
     */
    private static void binaryInsertSort(int[] a)
    {
        //从数组的第二个位置开始遍历值
        for(int i = 1; i < a.length; i++)  {
            int key = a[i];           //暂存要插入的值
            int pre = 0;              //有序序列开始和结尾下标申明
            int last = i - 1;
            // 折半查找出插入位置 a[pre]
            while(pre <= last)  {
                int mid = (pre + last) / 2;
                if(key < a[mid])  {
                    last = mid - 1;
                } else {
                    pre = mid + 1;
                }
            }
            //a[i]已经取出来存放在key中，把下标从pre + 1到 i-1的元素依次后移
            for(int j = i; j >= pre + 1; j--)  {
                a[j] = a[j - 1];
            }
            //把值插入空白位置
            a[pre] = key;
        }
    }

    private static void sort_1(int[] arr){
        for(int i = 1; i < arr.length; i ++){
            for(int j = i; j > 0; j --){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
