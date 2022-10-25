package com.example.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest2 {


    //6中lambda表达式
    //1没有参数和返回值
    //2有一个参数，没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("谎言和誓言的区别是什么");

        System.out.println("*****************");

        Consumer<String> con2 = (s) -> System.out.println(s);


        con2.accept("一个是听的人当真了，一个是说的人当真了");


    }

    @Test
    public void test3(){
        ArrayList<String> list = new ArrayList<>();

        int[] arr = {1,2,3};

    }

    @Test
    public void test5(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("************");

        Consumer<String> con2 = s-> {
            System.out.println(s);
        };
        con2.accept("一个是听的人当真了，一个是说的人当真了");

    }

    @Test
    public void test6(){

        Comparator<Integer> com1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com1.compare(12, 21));

        System.out.println("************");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com1.compare(12, 6));

    }

    @Test
    public void test7(){

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(12, 6));

    }


    @Test
    public void test8(){



    }
}
