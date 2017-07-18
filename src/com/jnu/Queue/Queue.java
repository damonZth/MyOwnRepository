package com.jnu.Queue;

/**
 * Created by Damon on 2017/6/14.
 * 队列的抽象数据类型
 * 定义一个队列的接口
 * 提供一些基本的方法
 * 比如：求队列的长度、判断队列是否为空、往队列中添加元素、往队列中插入一个元素、返回队列头元素
 */
public interface Queue<T> {

    int size();//求队列的大小、长度

    boolean isEmpty();//判断队列是否为空

    boolean isFull();//判断队列是否满

    boolean add(T data);//入队操作，成功则返回true，否则返回false

    boolean offer(T data);//offer方法向队列中插入一个元素。该方法只能通过抛出未检查的异常使添加元素失败，而不是出现异常的情况。

    T peek();//返回队首元素，不执行删除操作，若队列为空，则返回null

    T element();//返回队首元素，不执行删除操作，若队列为空，则抛出异常

    T poll();//出队操作：返回队首元素，并且删除队首元素，若队列为空，则返回null

    T remove();//出队操作：返回队首元素，并且删除队首元素，若队列为空，则抛出异常

    void clearQueue();//清空队列
}
