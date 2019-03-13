package com.sg.SimpleChat.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class PostThread {
    int id;
    LocalDateTime timestamp;
    List<Post> posts;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    
}
