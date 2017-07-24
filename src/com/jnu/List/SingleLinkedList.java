package com.jnu.List;

import com.jnu.Node.SingleNode;

/**
 * Created by Damon on 2017/7/19.
 */
public class SingleLinkedList<T> implements List<T> {
    private SingleNode<T> headNode;//头结点

    @Override
    public boolean isEmptly() {
        if(headNode == null){
            return true;
        }
        return false;
    }

    @Override
    public int length() {
       int length = 0;
       SingleNode<T> p = headNode;
       while(p != null){
           length ++;
           p = p.next;
       }
       return length;
    }

    @Override
    public T get(int index) {
        if(headNode == null || index < 0){
            return null;
        }
        int count = 0;
        SingleNode<T> p = headNode;
        while (p != null && count < index) {
            p = p.next;
            count++;
        }
        if (p != null) {
            return p.data;
        }
        return null;
    }

    @Override
    public boolean set(int index, T data) {
        if(headNode ==null || index < 0){
            return false;
        }
        SingleNode<T> node = new SingleNode(data);
        int count = 0;
        SingleNode<T> p = headNode;
        while(p != null && count < index){
            p = p.next;
            count ++;
        }
        p.next = node;
        return true;
    }

    @Override
    public boolean add(int index, T data) {
        return false;
    }

    @Override
    public boolean add(T data) {
        SingleNode<T> node = new SingleNode<>(data);
        SingleNode<T> p = headNode;
        while(p != null){
            p = p.next;
        }
        p.next = node;
        return true;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contain(T data) {
        return false;
    }

    @Override
    public int indexOf(T data) {
        return 0;
    }

    @Override
    public int lastIndexOf(T data) {
        return 0;
    }
}
