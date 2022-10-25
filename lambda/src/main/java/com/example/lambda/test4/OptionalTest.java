package com.example.demo.test4;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1(){

        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> girl1 = Optional.of(girl);


    }
}
