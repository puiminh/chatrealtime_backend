package com.project.chatrealtime_backend.controller;

import com.project.chatrealtime_backend.exeption.RoomNotFoundException;
import com.project.chatrealtime_backend.model.Room;
import com.project.chatrealtime_backend.repository.RoomRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
    List<Room> all(@RequestParam(required = false) Integer new_mess, @RequestParam(required = false) String name, @RequestParam(defaultValue = "10") Integer limit) {
        System.out.println(new_mess);
        System.out.println(name);
        System.out.println(limit);
        return (List<Room>) repository.findCustom(new_mess, name, limit);
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
                    if (newRoom.getName() != null) {
                        room.setName(newRoom.getName());
                    }
                    if (newRoom.getnew_mess() != null) {
                        room.setnew_mess(newRoom.getnew_mess());
                    }
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
