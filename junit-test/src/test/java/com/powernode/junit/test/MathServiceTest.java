package com.powernode.junit.test;

import com.powernode.junit.service.MathService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created On : 2022/10/24.
 * <p>
 * Author : Administrator
 * <p>
 * Description : 单元测试类
 */
public class MathServiceTest {

    //一个业务对应一个测试
    @Test
    public void testSum(){
        MathService mathService = new MathService();
        int sum = mathService.sum(1, 2);
        int expected = 3;
        Assert.assertEquals(expected,sum);
    }

    @Test
    public void testSub(){
        MathService mathService = new MathService();
        int actual = mathService.sub(10,5);
        int expected = 5;
        Assert.assertEquals(expected,actual);
    }


}
