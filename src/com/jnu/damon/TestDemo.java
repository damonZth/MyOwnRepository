package com.jnu.damon;

import com.jnu.threadDemo.MyThread;
import com.jnu.threadDemo.MyThread1;
import com.jnu.threadDemo.MyThread3;

/**
 * Created by Damon on 2017/7/24.
 */
public class TestDemo {
    public static void main(String[] args) throws Exception{
//        Outer outer = new Outer();
//        outer.fun_1();

        //外部实例化内部类对象的操作格式：
        //外部类.内部类 内部类对象 = new 外部类().new 内部类()
        //但是一般情况下，内部类都被private修饰，对外不可见
//        Outer.Inner inner = new Outer().new Inner();
//        inner.print();

//        Outer.Inner2 inner2 = new Outer.Inner2();
//        inner2.print();

        //new Outer().fun_3("world2");

//        MyThread myThread1 = new MyThread("线程A");
//        MyThread myThread2 = new MyThread("线程B");
//        MyThread myThread3 = new MyThread("线程C");
//        myThread1.run();
//        myThread2.run();
//        myThread3.run();
        //在程序中启动多线程，需要依靠Thread类中start()方法来启动多线程
        //start()方法会间接调用run()方法。
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();

//        MyThread1 myThread11 = new MyThread1("线程D");
//        MyThread1 myThread12 = new MyThread1("线程E");
//        MyThread1 myThread13 = new MyThread1("线程F");
        //用接口实现的线程主体类，想要启动线程，需要使用Thread来完成
        //创建新的线程类，将线程实例加载到线程类中，使用线程类启动
//        Thread thread1 = new Thread(myThread11);
//        Thread thread2 = new Thread(myThread12);
//        Thread thread3 = new Thread(myThread13);
//        thread1.start();
//        thread2.start();
//        thread3.start();

//        MyThread2 myThread21 = new MyThread2();
//        MyThread2 myThread22 = new MyThread2();
//        //使用FutureTask类来实现由Callable实现的多线程主体类
//        FutureTask<String> task1 = new FutureTask<String>(myThread21);
//        //取得call()方法返回结果
//        FutureTask<String> task2 = new FutureTask<String>((myThread22));
//        //FutureTask是Runnable接口的子类，故使用Thread类来启动多线程
//        new Thread(task1).start();
//        new Thread(task2).start();
//        //多线程执行完成后，可以使用FutureTask的父接口Future中的get()方法获取结果
//        System.out.println("线程1的返回结果：" + task1.get());
//        System.out.println("线程2的返回结果：" + task2.get());


//        MyThread2 myThread = new MyThread2("A");
//        FutureTask<String> task0 = new FutureTask<String>(myThread);
//        FutureTask<String> task1 = new FutureTask<String>(myThread);
//        Thread thread1 = new Thread(task0);
//        Thread thread2 = new Thread(task1);
//        thread1.setName("线程A");
//        thread2.setName("线程B");
//        System.out.println(thread1.getName() + ","+thread1.getId());
//        System.out.println(thread2.getName() + ","+thread2.getId());
//        thread1.start();
//        thread1.sleep(10);
//        thread2.start();

//        MyThread3 thread3 = new MyThread3();
//        new Thread(thread3,"线程A").start();
//        new Thread(thread3,"线程B").start();
//        new Thread(thread3,"线程C").start();
    }
}
