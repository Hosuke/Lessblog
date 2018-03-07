package com.hosuke.mapper;

import com.hosuke.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class PostMapperTest {

    @Test
    public void testPostMapper() {
        SqlSession session = MybatisUtils.getSession();
        PostMapper mapper = session.getMapper(PostMapper.class);
        System.out.println(mapper.selectById(85l));
        MybatisUtils.closeSqlSession();
    }

}
