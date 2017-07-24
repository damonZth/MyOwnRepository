package com.jnu.damon;

/**
 * Created by Damon on 2017/7/24.
 */
public class TestDemo {
    public static void main(String[] args){
//        Outer outer = new Outer();
//        outer.fun_1();

        //外部实例化内部类对象的操作格式：
        //外部类.内部类 内部类对象 = new 外部类().new 内部类()
        //但是一般情况下，内部类都被private修饰，对外不可见
//        Outer.Inner inner = new Outer().new Inner();
//        inner.print();

//        Outer.Inner2 inner2 = new Outer.Inner2();
//        inner2.print();

        new Outer().fun_3("world2");
    }
}
