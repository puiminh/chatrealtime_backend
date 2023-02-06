package com.project.chatrealtime_backend.repository;

import com.project.chatrealtime_backend.model.Message;
import com.project.chatrealtime_backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "select * from message where (?1 is null or id_room = ?1) and (?2 is null or name = ?2) and (?3 is null or sender = ?3)", nativeQuery = true)
    List<Message> findCustom(Integer id_room, String name, Integer sender);


}
