package com.project.chatrealtime_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Room {

    private @Id @GeneratedValue Integer id;
    private String name;
    private Boolean newMess;

    Room() {}

    public Room(Integer id, String name, Boolean newMess) {
        this.id = id;
        this.name = name;
        this.newMess = newMess;
    }

    public Room(String name, Boolean newMess) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(getId(), room.getId()) && Objects.equals(getName(), room.getName()) && Objects.equals(getNewMess(), room.getNewMess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNewMess());
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", newMess=" + newMess +
                '}';
    }
}