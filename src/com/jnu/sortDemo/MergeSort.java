package com.jnu.sortDemo;

/**
 * Created by Damon on 2017/7/26.
 * 归并排序： 建立在归并操作上的一种有效排序算法
 * 时间复杂度为O(nlogn) 　空间复杂度为 O(n)　
 * 归并排序，是创建在归并操作上的一种有效的排序算法。
 *
 * 分治：先使每个子序列有序，在将两个已经排序的序列合并成一个序列。
 *
 * 归并排序速度仅次于快速排序，是稳定排序，一般用于对总体无需，但各子序相对有序的记录。
 *
 * 将数组分成两组A，B。如果这两组内的数据都是有序的，那么就可以很方便的将这两组数据进行排序。
 * 分组———递归
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        int start = 1;
        int end = arr.length;
        sort(arr, start, end);
    }

    /**
     * 递归实现
     * ①将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素。
     * ②将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
     * ③重复步骤②，直到所有元素排序完毕
     * @param arr
     * @param start
     * @param end
     */
    private static void sort(int[] arr, int start, int end){
        if(end > start){
            int pos = (start + end)/2;
            sort(arr, start, pos);
            sort(arr,pos + 1, end);
            merge(arr, start, pos, end);
        }
    }

    /**
     * 合并操作
     * @param arr
     * @param start
     * @param pos
     * @param end
     */
    private static void merge(int[] arr, int start, int pos, int end){
       int len1 = pos - start + 1;
       int len2 = end - pos;
       int[] arr_A = new int[len1 + 1];
       int[] arr_B = new int[len2 + 1];
       for(int i = 0; i < len1; i ++){
           arr_A[i] = arr[i + start - 1];
       }
       arr_A[len1] = Integer.MAX_VALUE;
        for(int i = 0; i < len2; i ++){
            arr_B[i] = arr[i + pos];
        }
        arr_B[len2] = Integer.MAX_VALUE;

        int m = 0; int n = 0;
        for(int i = start - 1; i < end; i++){
            if(arr_A[m] > arr_B[n]){
                arr[i] = arr_B[n];
                n ++;
            }else{
                arr[i] = arr_A[m];
                m ++;
            }
        }
    }

    /**
     * 迭代实现
     * 实现原理
     * ①申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * ②设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * ③比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * ④重复步骤③直到某一指针到达序列尾
     * ⑤将另一序列剩下的所有元素直接复制到合并序列尾
     *
     * @param arr
     */
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        //用于合并的临时数组
        int[] result = new int[len];
        int block, start;

        //两两合并后块大小变大两倍 (注意最后一次block等于len)
        for(block = 1; block <=len ; block *= 2) {
            //把整个数组分成很多个块，每次合并处理两个块
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            //每次归并后把结果result存入arr中，以便进行下次归并
            int[] temp = arr;
            arr = result;
            result = temp;
        }

    }
}
