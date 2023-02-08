package com.project.chatrealtime_backend.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Room {

    private @Id @GeneratedValue Integer id;
    private String name;
    private Boolean newMess;

    @OneToMany(mappedBy = "id_room", cascade = CascadeType.ALL)
    private Collection<Message> messages;

    Room() {}

    public Room(Integer id, String name, Boolean newMess, Collection<Message> messages) {
        this.id = id;
        this.name = name;
        this.newMess = newMess;
        this.messages = messages;
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

    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
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