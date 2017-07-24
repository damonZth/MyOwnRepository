package com.jnu.damon;


/**
 * Created by Damon on 2017/7/24.
 */
public class Test_2 {
    public static void main(String[] args){
        //test_1();
        //test_2();
        //test_3();
        //test_5();
        //test_6();
        //test_7();

    }


    /**
     * "==" 和 equals()的区别：
     * == 操作符用来比较两个变量的值是否相等，即用于比较变量所对应的内存中所存储的数值是否相同。
     *      要比较两个基本类型的数据或者两个引用变量是否相等，只能用 == 操作符。
     * 如果一个变量指向的数据是对象类型，那么此时的比较久涉及到两块内存，即对象本身占用一块内存(堆中内存），引用变量也占用一块内存。
     * equals()方法是用来比较两个独立对象的内容是否相同。
     */
    public static void test_6(){
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "bcd";
//        System.out.println(str1 == str2);//true
//        System.out.println(str1.equals(str2));//true
//        System.out.println(str1 == str3);//false
//        System.out.println(str1.equals(str3));//false

        String objStr1 = new String("abc");//objStr1 变量在栈中存储着对象new String("abc")的首地址，对象new String("abc")中的值"abc"则存储在常量池中。
        String objStr2 = new String("abc");
        //objStr1、ObjStr2两个String变量分别指向了两个不同的对象，
        // 因此objStr1、ObjStr2的首地址数不同的，objStr1==ObjStr2为false
        //但是这两个对象中的内容是相同的，故objStr1.equals(objStr2)为true
        System.out.println(objStr1.equals(objStr2));//true
        System.out.println(objStr1 == objStr2);//false
    }

    /**
     * Math类中取整数方法的区别：ceil、floor、round
     * ceil 天花板， 表示向上取整
     * floor 地板，  表示向下取整
     * round “四舍五入” 算法为Math.floor(x+0.5)即将原来的数字加上0.5后再向下取整。
     */
    public static void test_7(){
        double double1 = 5.3;
        double double2 = 5.7;
        double double3 = -5.3;
        double double4 = -5.7;

        System.out.println(Math.ceil(double1));//6.0
        System.out.println(Math.floor(double1));//5.0
        System.out.println(Math.round(double1));//5
        System.out.println(Math.ceil(double2));//6.0
        System.out.println(Math.floor(double2));//5.0
        System.out.println(Math.round(double2));//6
        System.out.println(Math.ceil(double3));//-5.0
        System.out.println(Math.floor(double3));//-6.0
        System.out.println(Math.round(double3));//-5
        System.out.println(Math.ceil(double4));//-5.0
        System.out.println(Math.floor(double4));//-6.0
        System.out.println(Math.round(double4));//-6
    }

    /**
     * final关键字修饰一个变量时，是指引用变量不能改变，改变引用所指向的对象中的内容还是可以改变的。
     */
    public static void test_5(){
        final StringBuffer stringBuffer = new StringBuffer("immutable");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());
        //被final修饰的引用变量所指向的对象不能改变，但能改变对象里面的内容
        //stringBuffer = new StringBuffer("abc");
        //改变final修饰的引用变量指向对象的内容
        stringBuffer.append(" 你好");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());
    }

    /**
     * s1 = s1 + 1; s1 += 1; 区别？
     *
     */
    public static void test_4(){
        short s1 = 1;
        s1 = (short)(s1 + 1); //s1 = s1 + 1;中s1 + 1 运算时，自动将表达式类型提升到int型，而s1依旧是short类型，编译器将会报类型错误，需要强制类型转换。
        s1 += 1;// += 是 java 语言规定的运算符， java 编译器会对它进行特殊处理，因此，可以正确编译。
    }

    /**
     * switch语句：
     * switch(参数) {
     *      case 常量表达式1: break;
            case 常量表达式2: break;
            ...
            default: break;
     }
     * 在switch(参数)中，参数只能是一个整数表达式或者枚举常量。
     * 整数表达式可以是int基本类型或者Integer包装类型
     *      byte、short、char都可以隐含转换为int类型，因此，这些类型以及这些类型的包装类型也都可以。
     *   （错误）   long、String类型不符合switch的语法规定。并且不能被隐式转换成int类型，因此他们不能作用与switch语句
     */
    public static void test_3(){
        int count = 0;
        switch (count) {
            case 0:
                System.out.println("case0");
                break;
            case 1:
                System.out.println("case1");
                break;
            case 2:
                System.out.println("case2");
                break;
            case 3:
                System.out.println("case3");
                break;
            default:
                System.out.println("default!");
                break;
        }
        System.out.println("-------------------");
        //String能够用在switch语句中
        String msg = "dragon";
        switch (msg) {
            case "rabbit":
                System.out.println("rabbit ");
                break;
            case "dragon":
                System.out.println("happy new year");
                break;
            case "monkey":
                System.out.println("monkey");
                break;
            case "tiger":
                System.out.println("tiger!!");
                break;
            default:
                System.out.println("what ?");
                break;
        }
    }


    /**
     * & 与 && 的区别？
     * & 和 && 都可以用作逻辑与的运算符。表示逻辑与（and）：当运算符两边的表达式的结果都为true时，整个运算结果才为true，否则只要一方为false，则结果为false。
     * 区别：&& 具有短路功能，即如果第一个表达式为false，则不再计算第二个表达式。
     *       &  还可以用作位运算符，当&操作符两边的表达式不是boolean类型时，&表示按位与操作。
     */
    public static void test_1(){
        int i = 5;
        int j = 6;
        System.out.println(i == 5 & j == 6);
        System.out.println(i == 4 && j ==6);
        System.out.println(i == 4 & j ==6);
        System.out.println(i & j);

    }

    /**
     * java 中跳出当前的多重嵌套循环
     * 1、在java中，想要跳出多重循环，可以在外面的循环语句前定义一个标号，然后在里层循环体的代码中使用带有标号的break语句，即可跳出外层循环。
     * 2、让外层的循环条件表达式的结果受到里层循环体的代码的控制。例如：在二维数组中查找到某个数字
     */
    public static void test_2(){

        ok://外层循环标记
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.println("i = " + i + ";j = " + j);
                if(i== 2 && j == 3){
                    break ok;//跳出当前的j循环
                }
            }
        }

        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        boolean flag = false;
        for(int i = 0; i < arr.length && !flag; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println("i = " + i + ";j = " +j + ":"+ arr[i][j]);
                if(arr[i][j] == 6){
                    flag = true;
                    break;
                }
            }
        }
    }
}
