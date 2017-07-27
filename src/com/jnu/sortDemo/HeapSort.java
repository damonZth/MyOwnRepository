package com.jnu.sortDemo;

/**
 * Created by Damon on 2017/7/26.
 * 堆排序
 * 堆是一颗完全二叉树， 大顶堆、小顶堆
 *
 * 建堆：从一个数组中，顺序读取元素，建立一个堆
 * 初始化：将对进行调整，使得堆顶为最大或者最小的元素
 * 维护：将堆顶元素出堆后，需要将堆的最后一个节点补充到堆顶，因为这样破坏了堆的秩序，需要进行维护。
 *      过程：
 *      将堆顶元素出堆后，用最后一个元素补充堆顶元素位置。在堆顶元素的左右节点中选出较小的和堆顶互换，
 *      然后一直递归下去，所以每次出一个元素，需要一次维护。
 * 堆排序适合解决Top K 问题，能将复杂度降到nlogK。
 */
public class HeapSort {

    public static void heapSort(int[] arr){

        //1、建立大顶堆
        buildMaxHeapify(arr);
        //2、开始遍历，重排
        for (int i = arr.length - 1; i > 0; i --){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr,i,0);
        }
    }

   public static void print(int[] arr){
        int pre = -2;
        for(int i = 0; i < arr.length; i ++){
            if(pre < (int) getLog(i + 1)){
                pre = (int) getLog(i + 1);
                System.out.println();
            }
            System.out.print(arr[i] + "|");
        }
   }

    private static void buildMaxHeapify(int[] arr){
        //没有子节点的才需要创建大顶堆，从最后一个父节点开始
        int startIndex = getParentIndex(arr.length - 1);
        //从数组的末尾开始创建大顶堆
        for(int i = startIndex; i >= 0; i --){
            maxHeapify(arr, arr.length, i);
        }
    }

    /**
     * 创建大顶堆，
     * @param arr
     * @param heapSize 需要创建的大顶堆的大小
     * @param index 当前需要创建大顶堆的位置
     */
    private static void maxHeapify(int[] arr, int heapSize, int index){
        //当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if(left < heapSize && arr[index] < arr[left]){
            largest = left;
        }
        if(right < heapSize && arr[right] > arr[largest]){
            largest = right;
        }
        //得到最大值后可能需要交换，如果交换了，其子节点可能就不是大顶堆了，此时，需要重新调整
        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, heapSize, largest);
        }
    }

    /**
     * 父节点位置
     * @param current
     * @return
     */
    private static int getParentIndex(int current){
        return (current - 1) >> 1;
    }

    /**
     * 左节点的位置
     * @param current
     * @return
     */
    private static int getChildLeftIndex(int current){
        return (current << 1) + 1;
    }

    /**
     * 右节点的位置
     * @param current
     * @return
     */
    private static int getChildRightIndex(int current){
        return (current << 1) + 2;
    }

    /**
     * 以2为底，取对数
     * @param param
     * @return
     */
    private static double getLog(double param){
        return Math.log(param)/Math.log(2);
    }
}
