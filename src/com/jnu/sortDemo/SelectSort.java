package com.jnu.sortDemo;

/**
 * Created by Damon on 2017/7/26.
 * 选择排序  不稳定排序  最好情况时间：O(n^2)。 最坏情况时间：O(n^2)。
 * 与直接插入排序正好相反，选择排序是从待排序数据中选出最小的元素放在已排序的最后面，这个算法耗时在选数。
 * 交换移动数据次数少，比较次数多
 * 时间复杂度：O(n^2)
 * 在简选择排序过程中，所需移动记录的次数比较少。
 * 最好情况下，即待排序记录初始状态就已经是正序列，则不需要移动记录，只需要遍历比较
 * 最坏情况下，即待排序记录初始状态是按第一条记录最大，之后记录从小到大顺序排列，则需要移动记录的次数最多为3(n-1)，
 *
 *
 *
 */
public class SelectSort {

    public static void selectSort(int[] arr){
        sort(arr);
    }

    private static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int flag = i;//用来标记最小的数的位子
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j] < arr[flag]){
                    flag = j;
                }
            }
            if(flag != i){
                swap(arr, i, flag);
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
