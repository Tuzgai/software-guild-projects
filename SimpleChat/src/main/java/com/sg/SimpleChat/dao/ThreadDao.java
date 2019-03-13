package com.sg.SimpleChat.dao;

import com.sg.SimpleChat.entity.PostThread;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface ThreadDao {
    public List<PostThread> getAllThreads();
}
