package com.jnu.sortDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Damon on 2017/7/27.
 * 桶排序
 *  最差时间复杂度 　 O(n^2)
 *  平均时间复杂度 　O(n+k)
 *  最差空间复杂度　O(n*k)
 *
 *  对N个关键字进行桶排序的时间复杂度分为两个部分：
 *  ①循环计算每个关键字的桶映射函数，这个时间复杂度是O(N)。
 *  ②利用先进的比较排序算法对每个桶内的所有数据进行排序，其时间复杂度为 ∑ O(Ni*logNi) 。其中Ni 为第i个桶的数据量。
 *  很显然，第②部分是桶排序性能好坏的决定因素。尽量减少桶内数据的数量是提高效率的唯一办法(因为基于比较排序的最好平均时间复杂度只能达到O(N*logN)了)。因此，我们需要尽量做到下面两点：　
 *  ① 映射函数f(k)能够将N个数据平均的分配到M个桶中，这样每个桶就有[N/M]个数据量。　
 *  ②尽量的增大桶的数量。极限情况下每个桶只能得到一个数据，这样就完全避开了桶内数据的“比较”排序操作。 当然，做到这一点很不容易，数据量巨大的情况下，f(k)函数会使得桶集合的数量巨大，空间浪费严重。这就是一个时间代价和空间代价的权衡问题了。
 */
public class BucketSort {

    public static void bucketSort(double[] arr){
        sort(arr);
    }

    /**
     * 桶排序的步骤：
     * ①设置一个定量的数组当作空桶子。
     * ②寻访序列，并且把项目一个一个放到对应的桶子去。
     * ③对每个不是空的桶子进行排序。
     * ④从不是空的桶子里把项目再放回原来的序列中。
     * @param arr
     */
    private static void sort(double[] arr){
        //1、分桶
        ArrayList bucketList[] = new ArrayList[arr.length];//ArrayList类型数组
        for(int i = 0; i < arr.length; i ++){
            int temp = (int) Math.floor(arr.length * arr[i]);//对double类型数值，向下取整
            if(bucketList[temp] == null){
                //如果当前桶为空，则给当前桶分配一个ArrayList数组用来存放符合该桶的数值
                bucketList[temp] = new ArrayList();
            }
            bucketList[temp].add(arr[i]);//桶创建完成后，将arr[i]放入该桶
        }

        //2、桶内排序
        for(int i = 0; i < arr.length; i ++){
            if(bucketList[i] != null){
                Collections.sort(bucketList[i]);
            }
        }

        //将每个桶内排好序后，从桶中取数
        int count = 0;
        for(int i = 0; i < arr.length; i ++){
            if(bucketList[i] != null){
                Iterator iterator = bucketList[i].iterator();
                while(iterator.hasNext()){
                    Double temp = (Double)iterator.next();
                    arr[count] = temp;
                    count ++;
                }
            }
        }
    }

}
