package com.jnu.Queue;

import com.jnu.Node.SingleNode;

/**
 * Created by Damon on 2017/6/15.
 *
 * 采用链表实现队列：使用带头指针front和尾指针rear的单链表实现
 * front指向队首的第一个元素，rear指向队尾的最后一个元素
 * 初始时，front = rear = null，并且 front == null && rear == null 表示队列为空；
 * 当进行入队操作时，将带插入的元素节点更新在rear之后，并且更新rear指针指向新的队尾元素；
 * 当进行出队操作时，若队列不为空，获取队首元素节点，并删除队首节点元素，更新front指针指向front.next
 * 当第一个元素入队或者最后一个元素出队时，同时更新front指针和rear指针的指向第一个元素节点
 */
public class LinkQueue<T> implements Queue<T> {
    private SingleNode<T> front;
    private SingleNode<T> rear;
    private int size;
    private static final int MAXSIZE = 128;

    public LinkQueue(){
        //空构造器
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public boolean isFull() {
        if(size <= MAXSIZE) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean add(T data) {
        SingleNode<T> node = new SingleNode<>(data);
        if(this.front == null){
            this.front = node;
        }else{
           this.rear.setNext(node);
        }
        this.rear = node;
        size ++;
        return true;
    }

    @Override
    public boolean offer(T data) {
        if(data == null){
            throw new NullPointerException();
        }
        if(isFull()){
            throw new NullPointerException();
        }
        SingleNode<T> node = new SingleNode<>(data);
        if(this.front == null){
            this.front = node;
        }else{
            this.rear.setNext(node);
        }
        this.rear = node;
        size ++;
        return true;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }else{
            return front.getData();
        }
    }

    @Override
    public T element() {
        if(isEmpty()){
            throw new NullPointerException();
        }else{
            return front.getData();
        }
    }

    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }else{
            T temp = front.getData();
            this.front = this.front.getNext();
            if(this.front == null){
                this.rear = null;
            }
            size --;
            return temp;
        }
    }

    @Override
    public T remove() {
        if(isEmpty()){
            throw new NullPointerException();
        }else{
            T temp = this.front.getData();
            this.front = this.front.getNext();
            if(this.front == null){
                this.rear = null;
            }
            size--;
            return temp;
        }
    }

    @Override
    public void clearQueue() {
        this.front = this.rear = null;
        size = 0;
    }
}
