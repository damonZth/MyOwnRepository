package com.jnu.damon;
/**
 * Created by Damon on 2017/7/25.
 *
 * 使用Thread类实现多线程，但存在单继承问题
 *
 * 这里使用Runnable接口实现多线程
 */
public class MyThread1 implements Runnable { //线程的主体类
    private String title;

    public MyThread1(String title){
        this.title = title;
    }

    @Override
    public void run() {//线程的主方法
        for(int i = 0; i < 6; i++){
            System.out.println(this.title + "运行，i = " + i);
        }

    }
}
