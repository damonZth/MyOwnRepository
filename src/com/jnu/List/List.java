package com.jnu.List;

/**
 * Created by Damon on 2017/7/19.
 * 线性表的接口
 */
public interface List<T> {
    /**
     * 判断线性表是否为空
     * @return
     */
    boolean isEmptly();

    /**
     * 返回线性表的长度
     * @return
     */
    int length();

    /**
     * 获取index位的元素
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 将index位的值设置为data
     * @param index
     * @param data
     * @return
     */
    boolean set(int index, T data);

    /**
     * 根据index添加元素
     * @param index
     * @param data
     * @return
     */
    boolean add(int index, T data);

    /**
     * 添加元素
     * @param data
     * @return
     */
    boolean add(T data);

    /**
     * 根据index移除元素
     * @param index
     * @return
     */
    boolean remove(int index);
    /**
     * 根据data移除元素
     * @param data
     * @return
     */
    boolean removeAll(T data);

    /**
     * 清空线性表
     */
    void clear();

    /**
     * 判断线性表中是否包含data值
     * @param data
     * @return
     */
    boolean contain(T data);

    int indexOf(T data);
    /**
     * 查询线性表中最后出现data值的下标
     * @param data
     * @return
     */
    int lastIndexOf(T data);

    String toString();
}
