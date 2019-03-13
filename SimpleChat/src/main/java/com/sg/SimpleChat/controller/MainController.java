package com.sg.SimpleChat.controller;

import com.sg.SimpleChat.dao.PostDao;
import com.sg.SimpleChat.dao.ThreadDao;
import com.sg.SimpleChat.entity.Post;
import com.sg.SimpleChat.entity.PostThread;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class MainController {
    @Autowired
    PostDao postDao;
    
    @Autowired
    ThreadDao threadDao;
    
    @PostMapping("/")
    public String makePost(String name, String text, int threadId) {
        Post post = new Post();
        post.setName(name);
        post.setText(text);
        post.setThreadId(threadId);
        post.setTimestamp(LocalDateTime.now());
        postDao.addPost(post);
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String index(Model model) {
        List<PostThread> threads = threadDao.getAllThreads();
        model.addAttribute("threads", threads);
        
        return "index";
    }
}
