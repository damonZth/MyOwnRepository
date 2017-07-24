package com.jnu.damon;


/**
 * Created by Damon on 2017/7/19.
 */
public class VarianTest {

    /**
     * 静态变量前需要加static关键字，实例变量前则不加
     * 在程序运行时，实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被分配空间，才能使用这个实例变量。
     * 而静态变量不属于某个实例对象，而是属于类，故也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，静态变量都会被分配空间，静态变量也就可以使用了。
     *
     * 实例变量必须创建对象后才能通过这个对象来使用
     * 静态变量则可以直接使用类名来引用。
     */

    public static int staticVar = 0;
    public int instanceVar = 0;
    public VarianTest(){
        staticVar ++;
        instanceVar ++;
        System.out.println("staticVar=" + staticVar + ", instanceVar=" + instanceVar);
    }

    public static void main(String[] args){
        VarianTest v1 = new VarianTest();
        VarianTest v2 = new VarianTest();
        int a = VarianTest.staticVar;
        System.out.println(a);

    }
}
