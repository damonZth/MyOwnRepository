package com.jnu.Node;

import java.util.function.DoubleBinaryOperator;

/**
 * Created by Damon on 2017/7/18.
 */
public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> pre;
    public DoubleNode<T> next;

    public DoubleNode (){
        //空构造器
    }
    public DoubleNode(T data){
        this.data = data;
    }
    public DoubleNode(T data, DoubleNode<T> preNode){
        this.data = data;
        this.pre = preNode;
    }
    public DoubleNode(T data, DoubleNode<T> nextNode, DoubleNode<T> preNode){
        this.data = data;
        this.next = nextNode;
        this.pre = preNode;
    }
    public String toString(){
        return this.data.toString();
    }
}
