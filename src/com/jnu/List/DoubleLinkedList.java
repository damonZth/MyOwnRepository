package com.jnu.List;

import com.jnu.Node.DoubleNode;
import com.jnu.Node.SingleNode;

/**
 * Created by Damon on 2017/7/25.
 */
public class DoubleLinkedList<T> implements List {
    private DoubleNode<T> headNode;//头结点
    private DoubleNode<T> tail; //指向尾部的指针，提高效率

    public DoubleLinkedList(){
        this.headNode = this.tail = new DoubleNode<T>();
    }

    @Override
    public boolean isEmptly() {
        return headNode.next == null;
    }

    @Override
    public int length() {
        int length=0;
        DoubleNode<T> pre=headNode.next;
        while (pre != null){
            length++;
            pre=pre.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index >= 0)
        {
            int count=0;
            DoubleNode<T> pre = headNode.next;
            while (pre != null && count < index)
            {
                count ++;
                pre = pre.next;
            }
            if (pre != null)
                return pre.data;
        }
        return null;
    }

    @Override
    public boolean set(int index, Object data) {
        return false;
    }
/*
    @Override
    public boolean set(int index, T data) {
        if(headNode ==null || index < 0){
            return false;
        }
        int count = 0;
        DoubleNode<T> p = headNode;
        while(p != null && count < index){
            p = p.next;
            count ++;
        }
        if(p != null){
            p.data = data;
            return true;
        }
        return false;
    }
    */

    @Override
    public boolean add(int index, Object data) {
        return false;
    }

    @Override
    public boolean add(Object data) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean removeAll(Object data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contain(Object data) {
        return false;
    }

    @Override
    public int indexOf(Object data) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object data) {
        return 0;
    }
}
