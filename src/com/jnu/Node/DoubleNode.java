package com.jnu.Node;

import java.util.function.DoubleBinaryOperator;

/**
 * Created by Damon on 2017/7/18.
 */
public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> pre;
    private DoubleNode<T> next;

    public DoubleNode (){
        //空构造器
    }
    public DoubleNode(T data){
        this.data = data;
    }
//    public DoubleNode(T data, DoubleNode preNode){
//        this.data = data;
//        this.pre = preNode;
//    }
//    public DoubleNode(T data, DoubleNode<T> nextNode){
//        this.data = data;
//
//    }
}
