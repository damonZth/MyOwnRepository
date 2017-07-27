package com.jnu.sortDemo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Damon on 2017/7/26.
 * 快速排序，简称快排，是相对较快的一种排序
 * 最差时间复杂度 Ο(n^2)　最优时间复杂度 Ο(nlogn)    平均时间复杂度Ο(nlogn)
 * 设置两个指针 first last 分别指向第一个和最后一个，first向后移动，last向前移动
 * 选第一个数为标准，从后往前，找到第一个比标准小的数，互换位置，然后从前往后，找到第一个比标准大的数，互换位置，
 * 如此重复，直到标准左边的数都小于它，右边的数都大于它，这样完成一趟。
 * 如此递归，直到整个数组有序。
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        int first = 0;
        int last = arr.length - 1;
        sort(arr, first, last);
    }

    public static void quickSort(ArrayList arrayList){
       //
    }

    private static void sort(double[] arr, int first, int last){
        if(first > last){
            return;
        }
        if(first < last){
            //int temp = partition(arr,first, last);
            int temp = getMiddle(arr, first, last);
            sort(arr, first, temp - 1);
            sort(arr, temp + 1, last);
        }
    }

    private static void sort(int[] arr, int first, int last){
        if(first > last){
            return;
        }
        if(first < last){
            //int temp = partition(arr,first, last);
            int temp = getMiddle(arr, first, last);
            sort(arr, first, temp - 1);
            sort(arr, temp + 1, last);
        }
    }

    private static int getMiddle(double[] arr, int first, int last){
        double temp = arr[first];//数组的第一个作为中轴
        while(first < last){
            while(first < last && arr[last] >= temp){
                last --;
            }
            arr[first] = arr[last];//比中轴小的移到左边
            while(first < last && arr[first] <= temp){
                first ++;
            }
            arr[last] = arr[first];
        }
        arr[first] = temp;
        return first;
    }


    private static int getMiddle(int[] arr, int first, int last){
        int temp = arr[first];//数组的第一个作为中轴
        while(first < last){
            while(first < last && arr[last] >= temp){
                last --;
            }
            arr[first] = arr[last];//比中轴小的移到左边
            while(first < last && arr[first] <= temp){
                first ++;
            }
            arr[last] = arr[first];
        }
        arr[first] = temp;
        return first;
    }

    /*
    private static int partition(int[] arr, int first, int last){
        int key = arr[0];//标准
        while(first < last){
            while(first < last && arr[last] >= key){
                last --;
//                if(first < last){
//                    arr[first ++] = arr[last];
//                }
            }
            arr[first] = arr[last];
            while(first < last && arr[first] <= key){
                first ++;
//                if(first < last){
//                    arr[last --] = arr[first];
//                }

            }
            arr[last] = arr[first];
        }
        arr[first] = key;
        return first;
    }
    */
}
