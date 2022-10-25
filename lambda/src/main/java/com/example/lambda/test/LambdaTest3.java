package com.example.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created On : 2022/10/21.
 * <p>
 * Author : Administrator
 * <p>
 * Description : 消费型接口Consumer<T>,     void accept(T t)
 *              供给型接口 Supplier<T>      T get()
 *              函数型接口 Function<T,R>    R apply(T t)
 *              断言型接口 Predicate<T>     boolean test(T t)
 */
public class LambdaTest3 {

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买水喝，价格为："+ aDouble);
            }
        });

        System.out.println("*****************");

        happyTime(400,aDouble -> System.out.println("学习太累了，去天上人间买水喝，价格为："+ aDouble));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        ArrayList<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterString);


        List<String> filterStrs1 = filterString(list,s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

    //根据给定的规则，过滤集合中的字符串，此规则有Predicate的方法决定
    public ArrayList<String> filterString(List<String>list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;

    }

}
