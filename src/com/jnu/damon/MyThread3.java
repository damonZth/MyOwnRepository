package com.jnu.damon;

/**
 * Created by Damon on 2017/7/25.
 * 同步问题：指的是多个线程操作同一资源时所带来的安全性问题
 * 解决：多个操作在同一个时间段内只能有一个线程进行，其它线程必须等这个线程执行完成才可以继续执行。
 *
 */
public class MyThread3 implements Runnable {
    private int ticket = 10;

    //使用同步方法，实现资源的同步
    public synchronized void sale(){
        if(this.ticket > 0){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票，ticket = " + this.ticket--);
        }
    }

    @Override
    public void run() {

       for(int i = 0; i < 20; i++){
           this.sale();
       }
        //for(int i = 0; i < 20; i++){

            //使用同步代码块，实现资源的同步
//            synchronized (this){//在同步代码块内的代码，当前操作只允许一个对象进入
//                if(this.ticket > 0){
//                    try{
//                        Thread.sleep(1000);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "售票，ticket = " + this.ticket--);
//                }
//            }

            //不能同步
//            if(this.ticket > 0){
//                try{
//                    Thread.sleep(1000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "售票，ticket = " + this.ticket--);
//            }
 //       }
    }
}
