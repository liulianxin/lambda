package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 完整版mybatis程序
 */
public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();

            int insertCar = sqlSession.insert("insertCar");
            System.out.println(insertCar);
            sqlSession.commit();
        } catch (IOException e) {
            if(sqlSession != null){
                sqlSession.rollback();
            }

            e.printStackTrace();
        } finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
