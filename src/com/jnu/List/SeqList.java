package com.jnu.List;

/**
 * Created by Damon on 2017/7/19.
 * 顺序表的实现
 */
public class SeqList<T> implements List<T> {
    private T[] array;
    private int length;

    public SeqList(int capacity){
        //构造器初始化顺序表。
        this.length = 0;
        array = (T[])new Object[capacity];
    }

    @Override
    public boolean isEmptly() {
        if(length == 0){
            return true;
        }
        return false;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > length){
            return null;
        }
        return (T)this.array[index];
    }

    /**
     * 替换掉index位置的元素
     * @param index
     * @param data
     * @return
     */
    @Override
    public boolean set(int index, T data) {
        if(index < 0 || index > length){
            return false;
        }
        if(data != null){
            this.array[index] = data;
            return true;
        }
        return false;
    }


    /**
     * 在indx位置添加元素
     * @param index
     * @param data
     * @return
     */

    @Override
    public boolean add(int index, T data) {
       if(data == null){
           //如果元素为null，则添加失败
           return false;
       }
       if(index < 0){
           //如果index < 0 则将元素添加在线性表的首位
           index = 0;
       }
       if(index > this.length && index <= array.length){
           //如果index > length,则将元素添加在线性表的末尾
           index = this.length;
       }

       if(this.length + 1 > this.array.length){
           //数组满了的情况，需要数组扩容
           T[] temp = array;
           int oldArrayLength = this.array.length;
           this.array = (T[])new Object[2 * oldArrayLength];
           for(int i = 0; i < oldArrayLength; i++){
               array[i] = temp[i];
           }
           for(int i = length - 1; i >= index; i --){
               //将index之后的元素往后一个位子，空出index存放新的元素
                array[i+1] = array[i];
           }

       }
       this.array[index] = data;
        this.length ++;
        return true;
    }

    /**
     * 添加元素
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        if(data == null){
            return false;
        }
        return add(this.length, data);
    }

    /**
     * 根据下标删除元素
     * @param index
     * @return
     */
    @Override
    public boolean remove(int index) {
        if(index < 0 || index > length){
            return false;
        }
        for(int i = index; i < length - 1; i++){
            array[i] = array[i+1];
        }
        this.length --;
        return true;
    }

    /**
     * 根据data移除线性表中的所有值为data的元素
     * @param data
     * @return
     */
    @Override
    public boolean removeAll(T data) {
        for(int i = 0; i < length; i++){
            if(array[i] == data){
                for(int j = i; j < length - 1; j++){
                    array[j] = array[j+1];
                }
                this.length --;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.length=0;
    }

    @Override
    public boolean contain(T data) {
        return this.indexOf(data)>=0;
    }

    @Override
    public int indexOf(T data) {
        if (data!=null)
            for (int i=0; i<this.length; i++) {
                //相当则返回下标
                if (this.array[i].equals(data))
                    return i;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        if (data!=null)
            for (int i=this.length-1; i>=0; i--)
                if (data.equals(this.array[i]))
                    return i;
        return -1;
    }

    @Override
    public String toString()
    {
        String str="(";
        if (this.length!=0)
        {
            for (int i=0; i<this.length-1; i++)
                str += this.array[i].toString()+", ";
            str += this.array[this.length-1].toString();
        }
        return str+") ";
    }



}
