package com.jnu.DataStruct;

/**
 * Created by Damon on 2017/6/15.
 * 采用动态循环数组实现顺序循环队列：队列内部的数组可扩容，并按照原来队列的次序复制元素数组
 * 在队列填满元素的时候，如果仍然有元素需要入队，则对原数组进行扩容。
 * 在add方法中，首先通过 fornt = (rear + 1)%size 判断队列是否满，如果队列已经填满，则对原队列进行扩容，否则继续填充元素。
 * 数组扩容：主要是通过创建一个新容量的数组（一般情况下是原数组大小的2倍加1），并把旧数组中的元素复制到新的数组中。
 */
public class DynSeqArrayQueue<T> extends SeqArrayQueue<T> {
    private int capacity;//数组容量
    private int front;//队首下标
    private int rear;//队尾下标
    private int size;
    private T[] DynSeqArray;//定义一个循环数组，用来实现队列
    /*类的继承*/

    /**
     * 简单循环队列的构造器，传入一个capacity参数，确定数组的容量
     * 循环队列初始化时，front和rear下标都为0，表示队列为空。
     *
     * @param capacity
     */
    public DynSeqArrayQueue(int capacity) {
        this.capacity = capacity;
        DynSeqArray = (T[]) new Object[capacity];
        front = rear = 0;
    }

    /**
     * 返回队列大小：指循环数组中存在的元素个数
     * @return
     */
    @Override
    public int size() {
//        if(rear > front){
//            return (rear - front)%this.capacity;
//        }else {
//            return (front - rear)%this.capacity;
//        }
        return size;
    }

    /**
     * 判断队列是否为满：注意这里点队列为满时，数组中仍然有一个空的位置，主要是用来避免与队列为空的条件相同
     * @return
     */
    @Override
    public boolean isFull() {
        int temp = size();
        return temp == capacity - 1;
    }

    /**
     * 覆盖父类的入队方法
     * @param data
     * @return
     */
    public boolean add(T data){
        if(isFull()){
            ensureCapacity();
        }
        DynSeqArray[rear] = data;
        rear = (rear + 1)%this.capacity;
        size++;
        return true;
    }

    public boolean offer(T data){
        if(isFull()){
            ensureCapacity();
        }
        DynSeqArray[rear] = data;
        rear = (rear + 1)%capacity;
        size++;
        return true;
    }

    private void ensureCapacity(){
        T[] oldArray = DynSeqArray;
        int oldCapacity = this.capacity;
        int capacity = this.capacity * 2 + 1;
        DynSeqArray = (T[]) new Object[capacity];
        for(int i = 0; i < oldArray.length; i++){
            DynSeqArray[i] = oldArray[i];
        }
        if(rear < front){
            for(int i = 0; i < getFront(); i++){
                DynSeqArray[i + capacity] = DynSeqArray[i];
                DynSeqArray[i] = (T)null;
            }
            rear = rear + capacity;
        }

    }


}
