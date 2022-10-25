package com.example.demo.test3;

import com.example.demo.test2.Employee;
import com.example.demo.test2.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest2 {

    //1-匹配与查找
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2(){

        List<Employee> employees = EmployeeData.getEmployees();

        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        employees.stream().distinct().forEach(System.out::println);

        //比较最大薪资
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);

        //比较最小薪资
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
    }

}
