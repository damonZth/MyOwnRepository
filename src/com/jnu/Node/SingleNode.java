package com.jnu.Node;

/**
 * Created by Damon on 2017/6/14.
 * 单向节点
 * 节点只有一个指向后继节点的指针
 */
public class SingleNode<T> {
    private T data;//节点元素的数据
    private SingleNode<T> next;//后即节点

    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }

    public void setNext(SingleNode<T> next){
        this.next = next;
    }
    public SingleNode getNext(){
        return this.next;
    }

    public SingleNode(){
        //空的构造器
    }
    public SingleNode(T data){
        //带节点数据的构造器
        this.data = data;
    }

    public SingleNode(T data, SingleNode<T> next){
        //带节点数据和后继节点的构造器
        this.data = data;
        this.next = next;
    }

}
