package com.project.chatrealtime_backend.controller;

import com.project.chatrealtime_backend.exeption.MessageNotFoundException;
import com.project.chatrealtime_backend.model.Message;
import com.project.chatrealtime_backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private final MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/messages")
    List<Message> all(@RequestParam(required = false) Integer id_room, @RequestParam(required = false) String name, @RequestParam(required = false) Integer sender) {
        return (List<Message>) repository.findCustom(id_room,name,sender);
    }
    // end::get-aggregate-root[]

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        return repository.save(newMessage);
    }

    // Single item

    @GetMapping("/messages/{id}")
    Message one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    @PutMapping("/messages/{id}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Integer id) {

        return repository.findById(id)
                .map(message -> {
                    message.setMessage(newMessage.getMessage());
                    message.setSender(newMessage.getSender());
                    message.setId_room(newMessage.getId_room());
                    return repository.save(message);
                })
                .orElseGet(() -> {
                    newMessage.setId(id);
                    return repository.save(newMessage);
                });
    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
