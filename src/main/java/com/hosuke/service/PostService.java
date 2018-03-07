package com.hosuke.service;

import com.hosuke.entity.Post;
import com.hosuke.entity.PostEditDto;

import java.util.List;

public interface PostService {

    List<Post> getPostsPage(int pageNumber, int pageSize);

    List<Post> getPostsList(int pageNumber, int pageSize);

    List<Post> getTopPostsList();

    Post getPost(Long id);

    PostEditDto getEditablePost(Long id);

    List<Post> findPostsByTag(List<String> tags, int pageNumber, int pageSize);

    Post saveNewPost(PostEditDto postEditDto);

    Post updatePost(PostEditDto postEditDto);

    void setPostVisibility(Long postId, boolean hide);

    void deletePost(Long postId);

    void vote(Long postId, boolean like) throws Exception;
//    void vote(Long postId, boolean like) throws AlreadyVotedException;
}
