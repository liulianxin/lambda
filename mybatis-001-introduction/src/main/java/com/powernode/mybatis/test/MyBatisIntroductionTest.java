package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {

    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int insertCar = sqlSession.insert("insertCar");
        System.out.println(insertCar);

        sqlSession.commit();

    }


}
