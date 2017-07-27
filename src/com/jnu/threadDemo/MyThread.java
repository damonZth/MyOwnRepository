package com.jnu.threadDemo;

/**
 * Created by Damon on 2017/7/25.
 * 在java中，如果需要实现多线程程序，必须依靠一个线程的主体类，这个类可以继承Thread或者实现Runnable接口来实现定义。
 *
 * 1、继承Thread类实现多线程
 *  java.lang.Thread是一个负责线程操作的类，任何类继承了Thread类就可以成为一个线程的朱蕾。
 */
public class MyThread extends Thread{//线程主体类
    private String title;

    public MyThread(String title){
        this.title = title;
    }

    @Override
    public void run(){
        //线程的主方法
        for(int i = 0; i < 6; i++){
            System.out.println(this.title + "运行，i = " + i);
        }
    }
}
