package com.jnu.DataStruct;

import com.jnu.List.SeqList;

/**
 * Created by Damon on 2017/6/15.
 *
 */
public class Main {
    public static void main(String[] args){
//        ArrayQueue<Integer> aq = new ArrayQueue<>(3);
//        print(1,aq.isEmpty());
//        print(2,aq.isFull());
//        print(6,aq.peek());
//        print(7,aq.element());
//
//        print(0,aq.add(0));
//        print(0,aq.add(1));
//        print(0,aq.add(2));
//
//
//        print(3,aq.isFull());
//        print(4,aq.isEmpty());
//        print(5,aq.size());
//
//        aq.add(3);
//        aq.offer(4);
//
//        print(6,aq.peek());
//        print(9,aq.poll());
//        print(7,aq.element());
//        print(8,aq.poll());
//        print(6,aq.peek());
//        print(10,aq.remove());
//
//
//        print(0,aq.add(0));
//        print(0,aq.add(1));
//        print(0,aq.add(2));
//        print(111,aq.add(2));
//        print(3,aq.isFull());
//        print(5,aq.size());
//        aq.clearQueue();
//        print(3,aq.isFull());
//
//        print(9,aq.remove());

//        SeqArrayQueue<Integer> sq = new SeqArrayQueue<>(3);
//        print(1,sq.isEmpty());
//        print(2,sq.isFull());
//        print(5,sq.size());
//        print(3,sq.add(2));
//        print(5,sq.size());
//        print(4,sq.add(3));
//        print(5,sq.size());
//        print(6,sq.isFull());
//        print(7,sq.add(4));



//        DynSeqArrayQueue<Integer> dynSeqArrayQueue = new DynSeqArrayQueue<>(3);
//        print(1,dynSeqArrayQueue.isEmpty());
//        print(2,dynSeqArrayQueue.isFull());
//        print(3,dynSeqArrayQueue.size());
//        print(4,dynSeqArrayQueue.add(3));
//        print(5,dynSeqArrayQueue.size());
//        print(6,dynSeqArrayQueue.add(4));
//        print(7,dynSeqArrayQueue.size());
//        print(8,dynSeqArrayQueue.isFull());
//        print(9,dynSeqArrayQueue.add(6));
//        print(10,dynSeqArrayQueue.isFull());
//        print(11,dynSeqArrayQueue.size());

//        LinkQueue<Integer> lq = new LinkQueue<>();
//        print(0,lq.isFull());
//        print(0,lq.isEmpty());
//        print(1,lq.add(2));
//        print(2,lq.add(4));
//        print(3,lq.size());
//        print(4,lq.poll());
//        print(5,lq.size());
//        print(6,lq.peek());
//        print(7,lq.remove());
//        print(8,lq.size());


//        DynSeqArrayQueue<Integer> daq = new DynSeqArrayQueue<>(2);
//
//        print(1,daq.isEmpty());
//        print(2,daq.isFull());
//
//        print(3,daq.add(2));
//        print(4,daq.add(3));
//        print(5,daq.size());
//        print(6,daq.add(4));
//
//        print(7,daq.isFull());
//        print(8,daq.size());
        System.out.println("测试");

        SeqList<String> list = new SeqList<>(5);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("m");
        System.out.println( list.toString());
        list.add(2,"n");

        System.out.println( list.toString());
        System.out.println( list.get(2));
        System.out.println( list.isEmptly());



    }
    /**
     * 一个辅助的打印函数
     * @param index 索引
     * @param obj 对象
     */
    public static void print(int index,Object obj){
        System.out.println(String.format("{%d},%s",index,obj.toString()));
    }
}
