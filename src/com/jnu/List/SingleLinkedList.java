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
        //根据指针后移，遍历整个链表，计算链表的长度
       int length = 0;
       SingleNode<T> p = headNode;
       while(p != null){
           length ++;
           p = p.next;
       }
       return length;
    }

    /**
     * 根据index获取链表元素值
     * @param index
     * @return
     */
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

    /**
     * 根据index替换链表中的元素值
     * @param index
     * @param data
     * @return
     */
    @Override
    public boolean set(int index, T data) {
        if(headNode ==null || index < 0){
            return false;
        }

        int count = 0;
        SingleNode<T> p = headNode;
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

    /**
     * 向链表添加元素：
     * 1、在链表首部插入
     * 2、在链表中间插入
     * 3、在链表尾部插入
     * @param index
     * @param data
     * @return
     */
    @Override
    public boolean add(int index, T data) {
        if(data == null){
            return false;
        }
        //1、在链表首部插入
        if(headNode == null && index <= 0){
            headNode = new SingleNode<T>(data, headNode);
        }else{
            //2、在链表尾部插入和在链表中间插入都需要遍历到index位置
            int count = 0;
            SingleNode<T> p = headNode;
            while(p != null && count < index){
                //一定指针，查找到index位置
                p = p.next;
                count ++;
            }
            SingleNode<T> node = new SingleNode<>(data, p.next);
            p.next = node;
        }
        return true;
    }

    /**
     * 默认的 添加元素，向链表依次添加元素
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        SingleNode<T> node = new SingleNode<>(data, headNode.next);
        SingleNode<T> p = headNode;
        while(p != null){
            p = p.next;
        }
        p.next = node;
        return true;
    }

    /**
     * 根据索引删除元素节点
     * @param index
     * @return
     */
    @Override
    public boolean remove(int index) {
        if(headNode != null && index >= 0){
            if(index == 0){
                headNode = headNode.next;
                return true;
            }else{
                SingleNode<T> p = headNode;
                int count = 0;
                while(p != null && count < index){
                    p = p.next;
                    count ++;
                }
                if(p.next != null){
                    SingleNode<T> temp = p.next;
                    p.next = temp.next;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据data元素值删除链表中所有值为data的节点
     * @param data
     * @return
     */
    @Override
    public boolean removeAll(T data) {

        if(headNode != null && data != null){
            if(data.equals(headNode.data)){
                headNode = headNode.next;
            }else{
                SingleNode<T> p = headNode;
                SingleNode<T> temp = p.next;
                while(temp != null){
                    if(data.equals(temp.data)){
                        //如果temp节点的值为data，则删除temp节点
                        //1、将p节点的后继指针指向temp的后继节点
                        //2、将temp指针指向p的后继节点
                        //两步完成删除temp节点
                        p.next = temp.next;
                        temp = p.next;
                    }else{
                        p = temp;
                        temp = temp.next;
                    }

                }
            }
            return true;
        }
        return false;

    }

    @Override
    public void clear() {
        headNode = null;
    }

    @Override
    public boolean contain(T data) {
        if(headNode != null && data != null){
            SingleNode<T> p = headNode;
            while(p != null){
                if(data.equals(p.data)){
                    return true;
                }
                p = p.next;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T data) {
        int count = 0;
        if(headNode != null && data != null){
            SingleNode<T> p = headNode;
            while(p != null){
                if(data.equals(p.data)){
                    count ++;
                }
                p = p.next;
            }
        }
        return count;
    }

    @Override
    public int lastIndexOf(T data) {
        return length() - indexOf(data) - 1;
    }

    @Override
    public String toString()
    {
        String str="(";
        SingleNode<T> p = headNode;
        while (p!=headNode)
        {
            str += p.data.toString();
            p = p.next;
            if (p!=headNode)
                str += ", ";
        }
        return str+")";
    }
}
