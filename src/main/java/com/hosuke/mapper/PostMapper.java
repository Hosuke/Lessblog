package com.hosuke.mapper;

import com.hosuke.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface PostMapper {

    Post selectById(int id);

    //TODO: Complete this part
//    @Query("SELECT p FROM Post p WHERE :tagCount = (SELECT COUNT(DISTINCT t.id) FROM Post p2 JOIN p2.tags t WHERE LOWER(t.name) in (:tags) and p = p2)")
//    List<Post> findByTags(@Param("tags") Collection<String> tags, @Param("tagCount") Long tagCount);
//
//    @Query("SELECT p FROM Post p WHERE :tagCount = (SELECT COUNT(DISTINCT t.id) FROM Post p2 JOIN p2.tags t WHERE p.hidden = false and LOWER(t.name) in (:tags) and p = p2)")
//    List<Post> findByTagsAndNotHidden(@Param("tags") Collection<String> tags, @Param("tagCount") Long tagCount);
//
//    @Query("SELECT p FROM Post p JOIN p.postRatings r WHERE p.hidden = false GROUP BY p ORDER BY SUM(r.value) DESC")
//    List<Post> findTopPosts();
}
