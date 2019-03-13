package com.sg.SimpleChat.controller;

import com.sg.SimpleChat.Post;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
    ArrayList<Post> postList = new ArrayList<>();
    
    @PostMapping("/")
    public String makePost(String name, String text) {
        Post post = new Post();
        post.setName(name);
        post.setText(text);
        post.setTimestamp(LocalDate.now());
        postList.add(post);
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String index(Model model) {
        ArrayList<Post> output = new ArrayList<>();
        output.addAll(postList);
        Collections.reverse(output);
        model.addAttribute("posts", output);
        
        return "index";
    }
}
