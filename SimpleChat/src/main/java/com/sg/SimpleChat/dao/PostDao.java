package com.sg.SimpleChat.dao;

import com.sg.SimpleChat.entity.Post;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface PostDao {
    public List<Post> getPostsByThreadId(int id);
    public Post addPost(Post post);
}
