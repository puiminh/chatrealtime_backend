package com.project.chatrealtime_backend.exeption;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}