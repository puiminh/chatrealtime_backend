package com.project.chatrealtime_backend.controller;

import com.project.chatrealtime_backend.exeption.RoomNotFoundException;
import com.project.chatrealtime_backend.model.Room;
import com.project.chatrealtime_backend.repository.RoomRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomRepository repository;

    RoomController(RoomRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/rooms")
    List<Room> all() {
        return (List<Room>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/rooms")
    Room newRoom(@RequestBody Room newRoom) {
        return repository.save(newRoom);
    }

    // Single item

    @GetMapping("/rooms/{id}")
    Room one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PutMapping("/rooms/{id}")
    Room replaceRoom(@RequestBody Room newRoom, @PathVariable Integer id) {

        return repository.findById(id)
                .map(room -> {
                    room.setName(newRoom.getName());
                    room.setNewMess(newRoom.getNewMess());
                    return repository.save(room);
                })
                .orElseGet(() -> {
                    newRoom.setId(id);
                    return repository.save(newRoom);
                });
    }

    @DeleteMapping("/rooms/{id}")
    void deleteRoom(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
