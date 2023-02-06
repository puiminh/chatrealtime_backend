package com.project.chatrealtime_backend.exeption;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}