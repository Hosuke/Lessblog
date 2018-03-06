package com.hosuke.mapper;

import com.hosuke.entity.Post;
import com.hosuke.entity.PostRating;
import com.hosuke.entity.User;
import com.hosuke.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class PostRatingMapperTest {

    @Test
    public void testPostRatingMapper() {
        SqlSession session = MybatisUtils.getSession();
        PostRatingMapper mapper = session.getMapper(PostRatingMapper.class);

//        System.out.println(mapper.findUserRating(3l,  85l));
        PostRating postRating = new PostRating();
        Post post = new Post();
        post.setId(85l);
        postRating.setPost(post);
        User user = new User();
        user.setId(3l);
        postRating.setUser(user);
        System.out.println(mapper.findUserRating(postRating));

        MybatisUtils.closeSqlSession();
    }
}
