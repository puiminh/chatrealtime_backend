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
    List<Message> all(@RequestParam(required = false) Integer id_room, @RequestParam(required = false) Integer sender) {
        return (List<Message>) repository.findCustom(id_room,sender);
    }
    // end::get-aggregate-root[]

    @PostMapping("/messages")
    Message new_message(@RequestBody Message new_message) {
        return repository.save(new_message);
    }

    // Single item

    @GetMapping("/messages/{id}")
    Message one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    @PutMapping("/messages/{id}")
    Message replaceMessage(@RequestBody Message new_message, @PathVariable Integer id) {

        return repository.findById(id)
                .map(message -> {

                    message.setMessage(new_message.getMessage() != null ? new_message.getMessage() : message.getMessage());
                    message.setSender(new_message.getSender() != null ? new_message.getSender(): message.getSender());
                    message.setId_room(new_message.getId_room() != null ? new_message.getId_room() : message.getId_room());
                    return repository.save(message);
                })
                .orElseGet(() -> {
                    new_message.setId(id);
                    return repository.save(new_message);
                });
    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
