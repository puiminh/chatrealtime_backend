package com.project.chatrealtime_backend.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Message {

    private @Id @GeneratedValue Integer id;
    private Integer sender;
    private String message;
    private Integer id_room;

    Message() {}

    public Message(Integer sender, String message, Integer id_room) {
        this.sender = sender;
        this.message = message;
        this.id_room = id_room;
    }

    public Message(Integer id,Integer sender, String message, Integer id_room) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.id_room = id_room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId_room() {
        return id_room;
    }

    public void setId_room(Integer id_room) {
        this.id_room = id_room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message1 = (Message) o;
        return Objects.equals(getId(), message1.getId()) && Objects.equals(getSender(), message1.getSender()) && Objects.equals(getMessage(), message1.getMessage()) && Objects.equals(getId_room(), message1.getId_room());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSender(), getMessage(), getId_room());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", message='" + message + '\'' +
                ", id_room=" + id_room +
                '}';
    }
}