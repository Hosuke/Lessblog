package com.hosuke.mapper;

import com.hosuke.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void testUserMapper() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        System.out.println(mapper.findByUsernameIgnoreCase("admin"));
        System.out.println(mapper.findByEmailIgnoreCase("alice@gmail.com"));
        System.out.println(mapper.findByUsernameIgnoreCase("BOB"));
        MybatisUtils.closeSqlSession();
    }
}
