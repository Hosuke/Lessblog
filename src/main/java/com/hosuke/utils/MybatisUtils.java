package com.hosuke.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory ssf = null;
    //线程局部变量(多线程并发)
    private static ThreadLocal<SqlSession> tr = null;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("Mybatis.xml");
            tr = new ThreadLocal<>();
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        if (tr.get() == null){
            tr.set(ssf.openSession(true));
        }
        return tr.get();
    }

    //销毁session
    public static void closeSqlSession() {
        SqlSession session = tr.get();
        if (session != null) {
            session.close();
            tr.remove();
        }
    }
}