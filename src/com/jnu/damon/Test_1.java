package com.jnu.damon;

import java.util.ArrayList;


/**
 * Created by Damon on 2017/7/23.
 */
public class Test_1 {
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        list.add(434);
        list.add("zbc");
        Person person = new Person("damon", 22);
        list.add(person);
        System.out.println(list.toString());
        //System.out.println(person.toString());

        System.out.println(list.get(2));//自动调用类的tiString()方法


    }
}
class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age= age;
    }

    public String toString(){
        return "name:" + this.name + "age:" + this.age;
    }

}
