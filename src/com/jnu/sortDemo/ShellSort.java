package com.jnu.sortDemo;

/**
 * Created by Damon on 2017/7/26.
 * 希尔排序
 * 算法先将要排序的一组数按某个增量d分成若干组，每组中记录的下标相差d，对每组中全部元素进行直接插入排序。
 * 然后在用一个较小的增量d/2进行分组，在每组中进行直接插入排序。
 * 当增量减到1时，进行直接插入排序后，整个数组排序完成。
 */
public class ShellSort {

    public static void shellSort(int[] arr){
        sort(arr);
    }

//    public static int[] shellSort(int[] A, int n) {
//        //要插入的纸牌
//        int temp,j,i;
//        //设定增量D,增量D/2逐渐减小
//        for(int D = n/2;D>=1;D=D/2){
//            //从下标d开始，对d组进行插入排序
//            for(j=D;j<n;j++){
//                temp = A[j];
//                for(i=j;i>=D&&A[i-D]>temp;i-=D){
//                    A[i]=A[i-D];
//                }
//                A[i]=temp;
//            }
//        }
//        return A;
//    }

    private static void sort(int[] arr){
        int temp = 0;
        int gap = 1;
        int j = 0;
        while(gap < arr.length / 3){
            //初始化步长
            gap = gap * 3 + 1;
        }
        for(; gap > 0; gap /= 3){//循环遍历步长
            for(int i = gap; i < arr.length; i ++){
                temp = arr[i];
                for(j = i - gap; j >= 0 && arr[j] > temp; j -= gap){
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }
}
