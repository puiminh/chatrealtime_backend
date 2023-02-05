package com.project.chatrealtime_backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
class Room {

    private @Id @GeneratedValue Integer id;
    private String name;
    private Boolean newMess;

    Room() {}

    public Room(Integer id, String name, Boolean newMess) {
        this.id = id;
        this.name = name;
        this.newMess = newMess;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNewMess() {
        return newMess;
    }

    public void setNewMess(Boolean newMess) {
        this.newMess = newMess;
    }

}