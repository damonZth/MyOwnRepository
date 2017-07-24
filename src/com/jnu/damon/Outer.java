package com.jnu.damon;

/**
 * Created by Damon on 2017/7/24.
 * 内部类就是在一个类的内部定义的类，内部类中不能定义静态成员（因为静态成员不是对象的特性，只是为了找一个容身之所，才放在一个类中而已）
 * 内部类可以直接访问外部类中的而成员变量，内部类可以定义在外部类的方法外面，也可以定义在外部类的方法体中。
 *
 * 内部类属于一个类内部定义的新的结构。按照类的基本组成来讲，一个类应该由属性和方法组成，此时又多了有个内部类，
 * 内部类这种结构的最大缺点是破坏了程序的结构
 * 内部类的最大优点是，可以方便的访问外部类的私有操作，或者由外部类方便的访问内部类的私有操作
 */

public class Outer {//外部内
    private String msg = "hello world";//外部类的私有变量

    private class Inner{//内部类
        private String info = "你好";//内部类的私有变量
        public void print(){
            System.out.println(Outer.this.msg);//内部类方便的访问外部类的私有变量
        }
    }

    /**
     * 使用static定义的属性和方法，是独立于类之外的，可以在没有实例化对象的时候调用
     * 当static对内部类进行定义之后，使用了static定义的内部类则表示为“外部类”，并且只能访问外部类之中static类型的变量
     *
     */
    private static String str = " static hello world";
    static class Inner2{
        public void print(){
            //System.out.println(msg);
            System.out.println(str);//内部类访问外部类的静态变量
        }
    }

    public void fun_1(){
        Inner inner = new Inner();
        inner.print();
        System.out.println(inner.info);//外部类直接调用内部类的私有变量
    }
    public void fun_2(){
        Inner1 inner1 = new Inner1(this);
        inner1.print();
    }
    public void fun_3(final String str){
        /**
         * 如果一个方法中的内部类需要访问方法的参数或者方法中的变量时，这些参数或者变量前需要使用final关键字修饰。
         */
        final String info = "hello";
        class Inner3 {//在方法中定义内部类
            public void print(){
                System.out.println(Outer.this.msg);//内部类访问外部类私有变量
                System.out.println(info + str);
            }
        }
        Inner3 inner3 = new Inner3();
        inner3.print();
    }
    public String getMsg(){
        return msg;
    }
}

class Inner1{
    private Outer outer = null;
    public Inner1(Outer outer){
        this.outer = outer;
    }
    public void print(){
        System.out.println(this.outer.getMsg());
    }
}
