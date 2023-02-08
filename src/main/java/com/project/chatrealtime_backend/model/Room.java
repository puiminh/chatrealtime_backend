package com.project.chatrealtime_backend.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Room {

    private @Id @GeneratedValue Integer id;
    private String name;
    private Integer new_mess;

    @OneToMany(mappedBy = "id_room", cascade = CascadeType.ALL)
    private Collection<Message> messages;

    Room() {}

    public Room(Integer id, String name, Integer new_mess, Collection<Message> messages) {
        this.id = id;
        this.name = name;
        this.new_mess = new_mess;
        this.messages = messages;
    }

    public Room(String name, Integer new_mess) {
        this.name = name;
        this.new_mess = new_mess;
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

    public Integer getnew_mess() {
        return new_mess;
    }

    public void setnew_mess(Integer new_mess) {
        this.new_mess = new_mess;
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
        return Objects.equals(getId(), room.getId()) && Objects.equals(getName(), room.getName()) && Objects.equals(getnew_mess(), room.getnew_mess());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getnew_mess());
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", new_mess=" + new_mess +
                '}';
    }
}