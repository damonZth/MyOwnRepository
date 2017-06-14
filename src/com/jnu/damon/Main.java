package com.jnu.damon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println("高级项目学习第一天，2017.06.14");
//        System.out.println("改动测试");
        //操作符讲解
//        demoOperation();
        //字符串知识点
//        demoString();
        //控制流
//        demoControlFlow();
        //ArrayList
//        demoList();
        //HashMap
        demoMap();
    }

    public static void demoMap(){
        Map<String,String> map = new HashMap<String,String>();
        for(int i = 0; i < 4; i++){
            map.put(String.valueOf(i),String.valueOf(i * i));
        }

    }
    public static void demoList(){
        //O(n)
        List<String> strList = new ArrayList<String>();
        for(int i = 0; i < 4; i++){
            strList.add(String.valueOf(i));
        }
        print(1,strList);

        List<String> strListB = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            strListB.add(String.valueOf(i));
        }

        strList.addAll(strListB);
        print(2,strList);
        strList.remove(0);
        print(3,strList);
        strList.remove(String.valueOf(1));
        print(4,strList);
        print(5,strList.get(1));

        Collections.reverse(strList);
        print(6,strList);

        Collections.sort(strList);
        print(7,strList);
        Collections.sort(strList, new Comparator<String>() {//匿名内部类
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(8,strList);

        for(String obj : strList){
            print(9,obj);
        }

        for(int i = 0; i < strList.size(); i++){
            print(10,strList.get(i));
        }

        int[] array = new int[]{1,2,3};
        print(11,array[0]);
    }

    public static void demoControlFlow(){
        int a = 2;
        int target = a == 2 ? 1 : 3;
        print(1,target);

        if(a == 2){
            target = 1;
        }else if(a == 3){
            target = 4;
        }else{
            target = 5;
        }
        print(2,target);

        //ABC
        String grade = "B";
        switch (grade){
            case "A":
                print(3,">80");
                break;//break用来跳出分支
            case "B":
                print(4,"60-80");
                break;
            case "C":
                print(5,"<60");
                break;
            default:
                print(6,"未知");
                break;
        }

        for (int i = 0; i < 4; i++){
            if(i == 0){
                continue;//当前循环不执行
            }
            print(7,i);
            if(i == 2){
                break;//跳出循环
            }
        }

        int score = 60;
        //while循环，当while（true）则继续执行while里面的代码
        while(score < 100){
            print(8,score);
            score += 20;
        }

    }

    public static void demoString(){
        String str = "hello world";
        print(1,str);//打印str字符串
        print(2,str.charAt(2));//打印出字符串第二位的字符（从0开始）
        print(3,str.codePointAt(1));//打印出字符串第一位字符的在编码中的数字
        print(4,str.compareToIgnoreCase("HELLO WORLD"));//忽略大小，将字符串str与HELLO WORLD进行比较
        print(5,str.compareTo("hello uord"));//将字符串str与hello uord进行比较
        print(6,str.compareTo("hello xorld"));
        print(7,str.contains("hello"));//判断字符串str是否包含hello
        print(8,str.concat("GitHub"));//在字符串str后面接上GitHub字符串
        print(9,str.toUpperCase());//将字符串str该为大写
        print(10,str.endsWith("world"));//判断字符串是否以world结尾
        print(11,str.startsWith("hello"));//判断字符串是否以hello开始
        print(12,str.replace('o','e'));//将字符串中的o全部用e替代
        print(13,str.replaceAll("o|l","a"));
        print(14,str.replaceAll("hello","hi"));//字符串替代
        print(15,str + str);//这里都是创建了一个新的String对象来存储str + str

        //线程不安全的
        StringBuilder sb = new StringBuilder();//创建一个可变的字符串
        sb.append("x ");
        sb.append(1.2);
        sb.append('a');
        sb.append(true);
        print(16,sb.toString());

        //线程安全
        StringBuffer sb_1 = new StringBuffer();
    }

    public static void demoOperation(){
        print(1,5+2);
        print(2,5-2);
        print(3,5*2);
        print(4,5/2);
        print(5,5%2);
        print(6,5>>2);
        print(7,5<<2);
        print(8,5|2);
        print(9,5^2);
        print(10,5==2);
        print(11,5!=2);
    }

    /**
     * 一个辅助的打印函数
     * @param index 索引
     * @param object 对象
     */
    public static void print(int index,Object obj){
        System.out.println(String.format("{%d},%s",index,obj.toString()));
    }
}
