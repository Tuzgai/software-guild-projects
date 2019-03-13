package com.sg.SimpleChat.dao;

import com.sg.SimpleChat.entity.PostThread;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stuart
 */
@Repository
public class ThreadDaoDb implements ThreadDao {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    PostDao postDao;

    @Override
    public List<PostThread> getAllThreads() {
        final String GET_THREADS = "SELECT * FROM thread";

        List<PostThread> threads = jdbc.query(GET_THREADS, new PostThreadMapper());

        threads.forEach(thread -> thread.setPosts(postDao.getPostsByThreadId(thread.getId())));
        List<PostThread> output = threads.stream()
                .sorted((t1, t2) -> t2.getTimestamp().compareTo(t1.getTimestamp()))
                .collect(Collectors.toList());
        return output;
    }

    public static final class PostThreadMapper implements RowMapper<PostThread> {

        @Override
        public PostThread mapRow(ResultSet rs, int index) throws SQLException {
            PostThread pt = new PostThread();

            pt.setId(rs.getInt("id"));
            pt.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
            return pt;
        }
    }
}
