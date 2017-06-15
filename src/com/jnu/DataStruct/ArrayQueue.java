package com.jnu.DataStruct;

/**
 * Created by Damon on 2017/6/14.
 * 采用简单数组实现顺序队列：由队列的定义可知，只能在队列的一端进行入队操作，而在另一端进行出队操作。
 */
public class ArrayQueue<T> implements Queue<T>{
    private int front;//队首元素下标,队列非空时，front==0；
    private int rear;//队尾元素下标
    private int capacity;//数组容量
    private T[] array;//定义一个简单数组，用来实现顺序队列

    /**
     * 该构造器，接收一个数组容量参数，产生一个容量为capacity的简单数组，用来实现顺序队列
     * 简单数组实现的顺序队列
     * 初始化队列，队首元素下标和队尾元素下标 front = rear = -1;表示队列为空
     *
     * 泛型数组不能通过 T[] a = new T[length];创建，
     * 而是通过 T[] a = (T[])new Object[length];来创建，
     * 因为对于没有限定的类型变量，类型擦除后用Object代替T，变为 Object[] a = (Object[]) new Object[length];
     * 这样，编译器是可以通过的！！
     * @param capacity 数组容量
     */
    public ArrayQueue(int capacity){
        this.capacity = capacity;
        front = -1;
        rear = -1;
        array = (T[])new Object[capacity];
    }

    /**
     * 返回队列的大小：指顺序队列中元素的个数，并不是数组的大小
     * 通过计算数组队首下标和队尾下标之间的距离，而得到队列的长度
     * @return
     */
    @Override
    public int size() {
        return rear - front + 1;
    }

    /**
     * 判断队列是否为空
     * 根据初始化条件进行判断，即front = rear = -1
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    /**
     * 判断队列是否满
     * 如果队列满，那么front在数组的第0位上，rear在数组的最后一位上
     * @return
     */
    @Override
    public boolean isFull() {
        if(size() == capacity){
            return true;
        }
        return false;
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
            if(front == -1){
                front = rear = 0;
                array[front] = data;
                array[rear] = data;
//                return true;
            }else{
                array[rear+1] = data;
                rear = rear + 1;
//                return true;
            }
            return true;
//            if(front == -1){
//                //如果入队的是第一个元素，则需要同时改变队首下标和队尾下标
//                front = rear;
//            }
        }
    }

    /**
     * offer方法向队列中插入一个元素。该方法只能通过抛出未检查的异常使添加元素失败，而不是出现异常的情况。
     * @param data
     * @return
     */
    @Override
    public boolean offer(T data) {
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(front == -1){
            front = rear = 0;
            array[front] = data;
            array[rear] = data;

        }else{
            array[rear+1] = data;
            rear = rear + 1;
        }
        return true;
    }

    /**
     *返回队首元素，不执行删除操作，若队列为空，则返回null
     * @return
     */
    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }else{
            return array[front];
        }
    }

    /**
     * 出队操作：返回队首元素，不执行删除操作，若队列为空，则抛出异常
     * @return
     */
    @Override
    public T element() {
        if (isEmpty()) {
            throw new NullPointerException();
        }else{
            return array[front];
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
           T temp = array[front];
           move();
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
            throw new NullPointerException();
        }else{
            T temp = array[front];
            move();
            return temp;
        }
    }

    /**
     * 清空队列
     */
    @Override
    public void clearQueue() {
        front = rear = -1;

    }

    /**
     * 当删除队首元素时，需要将数组中的所有元素向前移动一位
     */
    private void move(){
        for (int i = front; i < rear; i++) {
            //移除队首元素后，需要将数组中的后序元素往前移动一位
            array[i] = array[i + 1];
        }
        rear = rear -  1;//当所有元素都向前移动一位后，队尾指针也需要自减一位。
    }
}
