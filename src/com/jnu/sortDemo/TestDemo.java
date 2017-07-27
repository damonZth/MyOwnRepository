package com.jnu.sortDemo;

import java.util.Random;

/**
 * Created by Damon on 2017/7/26.
 */
public class TestDemo {
    public static void main(String[] args){
        int[] arr = { 9, 2, 7, 19, 100, 97, 63, 208, 55, 78 };
        double[] doubleArr = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.26, 0.12, 0.23, 0.68};
        int[] array = {278,109,63,930,589,184,505,269,8,83};

//        System.out.println("==========1、基数排序===========");
//        print(array);
//        RadixSort.radixSort(array);
//        print(array);
//
//        System.out.println("=========2、桶排序===========");
//        print(doubleArr);
//        BucketSort.bucketSort(doubleArr);
//        print(doubleArr);
//
//        System.out.println("==========3、插入排序===========");
//        print(arr);
//        InsertSort.insertSort(arr);
//        print(arr);
//
//        System.out.println("=========4、选择排序===========");
//        print(arr);
//        SelectSort.selectSort(arr);
//        print(arr);
//
//        System.out.println("==========5、快速排序===========");
//        print(arr);
//        QuickSort.quickSort(arr);
//        print(arr);
//
        System.out.println("==========6、冒泡排序===========");
        print(arr);
        BubbleSort.bubbleSort(arr);
        print(arr);
//
//        System.out.println("=========7、归并排序===========");
//        print(arr);
//        MergeSort.mergeSort(arr);
//        print(arr);
//
//        System.out.println("=========8堆排序===========");
//        print(arr);
//        HeapSort.heapSort(arr);
//        print(arr);
//
//        System.out.println("==========9、计数排序===========");
//        print(arr);
//        CountingSort.countSort(arr);
//        print(arr);
//
//        System.out.println("=========10、希尔排序===========");
//        print(arr);
//        ShellSort.shellSort(arr);//有问题
//        print(arr);

    }

    private static int getMax(int[] arr){
        int flag = 0;//用来记录最大的数
        for(int i = 0; i < arr.length; i ++){
            flag = i;
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j] > arr[flag]){
                    flag = j;
                }
            }
            if(flag != i){
                break;
            }
        }
        return arr[flag];
    }

    private static int getMin(int[] arr){
        int flag = 0;//用来记录最小的数
        for(int i = 0; i < arr.length; i ++){
            flag = i;
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j] < arr[flag]){
                    flag = j;
                }
            }
            if(flag != i){
                break;
            }
        }
        return arr[flag];
    }

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void print(double[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
