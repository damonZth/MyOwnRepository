package com.jnu.sortDemo;

/**
 * Created by Damon on 2017/7/26.
 * 冒泡排序   小的数一点一点向前起泡，最终有序。
 * 冒泡排序通过重复的遍历数组，每次比较两个元素，如果它们的顺序错误，就将它们的位置调换，直到遍历整个数组没有需要交换位置的元素为止。
 *
 * 冒泡排序的时间复杂度为O(n^2),空间复杂度为O(1)。
 *
 * 步骤：
 * 1、比较相邻的两个元素，如果第一个比第二个大，则交换它们的位置。
 * 2、对每一对相邻元素做步骤1的工作。从开始的第一对到结尾的最后一对，每完成一趟遍历，都有一个最大的数到达未排序的数组末端。
 * 3、重复1、2步骤。n个元素需要n^2次的比较
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        //sort(arr);
        sort_1(arr);
    }

    private static void sort(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            for(int j = arr.length - 1; j > i; j --){
                if(arr[j] < arr[j - 1]){
                    swap1(arr, j, j-1);
                }
            }
        }
    }

    /**
     * 还有问题
     * @param arr
     */
    private static void sort_1(int[] arr){
        boolean flag = true;
        int n = arr.length;
        while(flag){
            flag = false;
            for(int i = 0; i < n - 1; i ++){
                if(arr[i] > arr[i+1]){
                    swap1(arr, i, i+1);
                    flag = true;
                }
            }
            n --;
        }
    }

//    public static void bubbleSort_1(int[] arr){
//
//    }

    private static void swap(int[] arr,int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    private static void swap1(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
