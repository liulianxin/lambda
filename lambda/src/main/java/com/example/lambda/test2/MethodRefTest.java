package com.example.demo.test2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 *
 * 方法引用的使用
 *
 * 1.使用情境： 当要传递给Lambda体的操作，已经有实现的方法了。可以使用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式
 *
 * 3. 使用格式： 类（或对象） :: 方法名
 *
 * 4 具体分为以下三种情况
 *     对象 ：： 非静态方法
 *     类 ：： 静态方法
 *     类 ：： 非静态方法
 *
 * 5 方法引用：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表相同
 */

public class MethodRefTest {

    //情况一：对象 ：： 实例方法
    //Consumer中的void accept（T t）
    //PrintStream中的void println（T t）
    @Test
    public void test1(){

        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("************");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps :: println;
        con2.accept("beijing");

    }


    @Test
    public void test2(){

        Employee emp = new Employee(1001,"Tom",23,5600);
        Supplier<String> sup1 = ()-> emp.getName();
        System.out.println(sup1.get());

        System.out.println("******************");

        Supplier<String> sup2 = emp::getName;

    }

    @Test
    public void test3(){

        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 21));

        System.out.println("******************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 3));

    }


    @Test
    public void test4(){

        Function<Double,Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(func.apply(12.2));

        System.out.println("********************");

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.5));

        System.out.println("********************");

        Function<Double,Long> func2 = Math :: round;



    }

}
