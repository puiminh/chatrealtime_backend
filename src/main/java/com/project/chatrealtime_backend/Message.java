package com.project.chatrealtime_backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Message {

    private @Id @GeneratedValue Integer id;
    private String name;
    private Integer newMess;

    Message() {}

}