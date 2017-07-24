package com.jnu.damon;

import java.util.Date;

/**
 * Created by Damon on 2017/7/19.
 */
public class Test extends Date {
    public static void main(String[] args){
        new Test().test();
        new Test().test1();


    }
    public void test(){
        System.out.println(super.getClass().getName());
    }
    public void test1(){
        System.out.println(getClass().getSuperclass().getName());
    }


}
