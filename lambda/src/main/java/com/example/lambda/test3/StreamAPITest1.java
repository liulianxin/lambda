package com.example.demo.test3;

import com.example.demo.test2.Employee;
import com.example.demo.test2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest1 {

    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

        //返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5,6};

        IntStream stream = Arrays.stream(arr);

    }

    @Test
    public void test4(){
        //自然排序
//        List<Integer> list = Arrays.asList(12,33,54,23,0,-98);
//        list.stream().sorted().forEach(System.out::println);

        //抛异常，emplouee类没有实现COmparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
                .forEach(System.out::println);


    }

}
