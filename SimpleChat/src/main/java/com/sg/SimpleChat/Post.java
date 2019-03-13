package com.sg.SimpleChat;

import java.time.LocalDate;

/**
 *
 * @author Stuart
 */
public class Post {

    String name;
    String text;
    LocalDate timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    
}
