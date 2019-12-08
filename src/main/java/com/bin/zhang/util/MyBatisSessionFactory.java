package com.bin.zhang.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionFactory {
    private static final String resource = "mybatis-sessionfactory-config.xml";
    private static ThreadLocal<SqlSession> sessionThreadLocal=new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory=null;
    private static InputStream inputStream=null;
    public static void rebuildSqlSessionFactory() throws IOException {
         inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         //使用annotation注解的方式进行配置
        sqlSessionFactory.getConfiguration().addMappers("cn.bin.zhang.dao");
    }
    public static SqlSession getSession() throws IOException {
        SqlSession sqlSession=sessionThreadLocal.get();
        if(sqlSession==null){
           if(sqlSessionFactory==null) {
               rebuildSqlSessionFactory();
           }
           sqlSession=sqlSessionFactory.openSession();
           sessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    public static SqlSessionFactory getSessionFactory(){
        return sqlSessionFactory;
    }
    public static void close(){
        SqlSession session=sessionThreadLocal.get();
        if(session!=null){
            session.close();
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sessionThreadLocal.remove();
        }
    }
}
