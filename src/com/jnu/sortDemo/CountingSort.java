package com.jnu.sortDemo;

/**
 * Created by Damon on 2017/7/26.
 * 计数排序
 * 对于给定的的输入数组中的每一个元素x，确定该数组中只小于x的元素的格式
 *
 * 步骤：
 * 1、找出数组中的最大值和最小值
 * 2、统计数组中每个值为i的元素的出现次数，存入新的数组C的第i项
 * 3、对所有的计数累加，（从C中的第一个元素开始，每一项和前一项相加）
 * 4、反向填从目标数组：将每个元素i放在新数组的第C[i]项，每放一个元素就将C[i]-1。
 *
 */
public class CountingSort {

    public static void countSort(int[] arr){
        int max = getMax(arr);
        sort(arr, max);

    }

    private static void sort(int[] arr, int max){

        int[] temp = new int[max + 1];
        //初始化数组
        for(int i = 0; i < max + 1; i ++){
            temp[i] = 0;
        }

        //计算数组中每个元素出现的次数，存入数组temp中的第i项。即元素中的元素值为temp数组中的项值
        for(int i = 0; i < arr.length; i ++){
            temp[arr[i]] = temp[arr[i]] + 1;
        }

        //计算数组中小于等于每个元素的个数。即从temp中的第一个元素开始，每一项和前一项相加
        for(int i = 1; i < max + 1; i ++){
            temp[i] = temp[i] + temp[i - 1];
        }

        //result数组用来存放排好序的数组
        int[] result = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i --){
            result[temp[arr[i]] - 1] = arr[i];
            temp[arr[i]] = temp[arr[i]] - 1;
        }

        //将原数组用已排好序的数组覆盖
        for(int i = 0; i < arr.length; i ++){
            arr[i] = result[i];
        }
    }

    /**
     * 获取数组中的最小元素
     * @param arr
     * @return
     */
    private static int getMin(int[] arr){
        int flag = 0;//用来记录最大的数
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

    /**
     * 获取数组中最大的数
     * @param arr
     * @return
     */
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

    private static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
