package com.sg.SimpleChat.dao;

import com.sg.SimpleChat.entity.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stuart
 */
@Repository
public class PostDaoDb implements PostDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Post> getPostsByThreadId(int id) {
        final String GET_POSTS = 
                "SELECT p.* FROM post p " +
                "JOIN thread t ON p.threadId = t.id " +
                "WHERE t.id = ?";
        
        List<Post> posts = jdbc.query(GET_POSTS, new PostMapper(), id);
        return posts;
    }

    @Override
    @Transactional
    public Post addPost(Post post) {
        final String INSERT_POST = "INSERT INTO post(`name`, `text`, threadId) VALUES(?,?,?)";
        final String INSERT_THREAD = "INSERT INTO thread VALUES (DEFAULT, DEFAULT)";
        
        // If we are starting a new thread, make it
        if(post.getThreadId() == 0) {
            jdbc.update(INSERT_THREAD);
            post.setThreadId((jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class)));
        }
        
        // Then add the post
        jdbc.update(INSERT_POST,
                post.getName(),
                post.getText(),
                post.getThreadId());
        
        post.setId(jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        post.setTimestamp(jdbc.queryForObject("SELECT `timestamp` FROM post WHERE post.id = ?", LocalDateTime.class, post.getId()));
        
        return post;
    }
    
    public static final class PostMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int index) throws SQLException {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setName(rs.getString("name"));
            post.setText(rs.getString("text"));
            post.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
            post.setThreadId(rs.getInt("threadId"));
            
            return post;
        }
    }
}
