package com.jnu.DataStruct;

/**
 * Created by Damon on 2017/6/15.
 * 采用简单循环数组实现循环顺序列表
 * 采用简单循环数组实现顺序循环队列：将顺序队列设计为在逻辑结构上首尾相接的循环结构。
 * 在给简单数组添加一个头指针front和尾指针rear，其中 front = (front+1)%size 和 rear = (rear + 1)%size 的下标取值范围是[0,size-1]
 * 初始时，front = rear = 0：表示队列为空；
 * 当进行入队操作时，rear = (rear + 1)%length,也就是front向前移动一位
 * 当进行出队操作是，front = (front + 1)%length，也就是rear向后移动一位
 * 当队列为满时，front=(rear+1)%size，此时队列中仍然有一个空的位置，主要是用来避免与队列为空的条件相同
 */
public class SeqArrayQueue<T> implements Queue<T>{
    private int capacity;//数组容量
    private int front;//队首下标
    private int rear;//队尾下标
    private int size;//记录队列中元素个数
    private T[] SeqArray;//定义一个循环数组，用来实现队列


    public T[] getSeqArray(){
        return this.SeqArray;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setFront(int front){
        this.front = front;
    }
    public int getFront(){
        return front;
    }
    public void setRear(int rear){
        this.rear = rear;
    }
    public int getRear(){
        return rear;
    }

    public SeqArrayQueue(){
        //空的构造器
    }
    /**
     * 简单循环队列的构造器，传入一个capacity参数，确定数组的容量
     * 循环队列初始化时，front和rear下标都为0，表示队列为空。
     * @param capacity
     */
    public SeqArrayQueue(int capacity){
        this.capacity = capacity;
        SeqArray = (T[]) new Object[capacity];
        front = rear = 0;
    }

    /**
     * 返回队列大小：指循环数组中存在的元素个数
     * @return
     */
    @Override
    public int size() {
//        if(rear > front){
//            return (rear - front)%capacity;
//        }else {
//            return (front - rear)%capacity;
//        }
        return size;
    }

    /**
     * 判断队列是否为空：
     * 如果front和rear的下标相同，则表示队列为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == rear;
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
     * 入队操作，成功则返回true，否则返回false
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        if(isFull()){
            return false;
        }else{
            SeqArray[rear] = data;
            rear = (rear + 1)%capacity;
            size++;
            return true;
        }
    }

    /**
     * offer方法向队列中插入一个元素。该方法只能通过抛出未检查的异常使添加元素失败，而不是出现异常的情况。
     * @param data
     * @return
     */
    @Override
    public boolean offer(T data) {
        if(isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }else{
            SeqArray[rear] = data;
            rear = (rear + 1)%capacity;
            size++;
            return true;
        }
    }

    /**
     * 返回队首元素，不执行删除操作，若队列为空，则返回null
     * @return
     */
    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }else{
            return SeqArray[front];
        }
    }

    /**
     * 出队操作：返回队首元素，不执行删除操作，若队列为空，则抛出异常
     * @return
     */
    @Override
    public T element() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            return SeqArray[front];
        }
    }

    /**
     * 出队操作：返回队首元素，并且删除队首元素，若队列为空，则返回null
     * @return
     */
    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }else{
            T temp = SeqArray[front];
            front = (front + 1)%capacity;
            size--;
            return temp;
        }
    }

    /**
     * 出队操作：返回队首元素，并且删除队首元素，若队列为空，则抛出异常
     * @return
     */
    @Override
    public T remove() {
       if(isEmpty()){
           throw new ArrayIndexOutOfBoundsException();
       }else{
           T temp = SeqArray[front];
           front = (front + 1)%capacity;
           size--;
           return temp;
       }
    }

    /**
     * 清空队列
     */
    @Override
    public void clearQueue() {
        for(int i = 0; i != rear; i= (i+1)%capacity){
            SeqArray[i] = null;
        }
        front = rear = 0;
        size = 0;
    }
}
