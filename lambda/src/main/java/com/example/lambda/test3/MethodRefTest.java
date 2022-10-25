package com.example.demo.test3;

import com.example.demo.test2.Employee;
import com.example.demo.test2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodRefTest {

    @Test
    public void test(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
//        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        Optional<Double> reduce1 = doubleStream.reduce((e1, e2) -> e1 + e2);
        System.out.println(reduce1);
    }


    //收集
    @Test
    public void test4(){

        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);


        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toSet());
        collect1.stream().forEach(System.out::println);
    }
}
