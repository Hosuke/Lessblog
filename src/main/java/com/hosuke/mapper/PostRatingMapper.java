package com.hosuke.mapper;

import com.hosuke.entity.Post;
import com.hosuke.entity.PostRating;
import com.hosuke.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostRatingMapper {

//    @Query("SELECT r FROM PostRating r WHERE r.post.id = :postId AND r.user.id = :userId")

    List<PostRating> selectByPost(int postId);


    // Unable to work FIXME
//    PostRating findUserRating(@Param("post_id") Long postId, @Param("user_id") Long userId);
    PostRating findUserRating(PostRating postRating);

//    default PostRating findUserRating(Long postId, Long userId) {
//        PostRating postRating = new PostRating();
//        Post post = new Post();
//        post.setId(postId);
//        postRating.setPost(post);
//        User user = new User();
//        user.setId(userId);
//        postRating.setUser(user);
//        System.out.println(postRating);
//        return this.findUserRating(postRating);
//    }
}
