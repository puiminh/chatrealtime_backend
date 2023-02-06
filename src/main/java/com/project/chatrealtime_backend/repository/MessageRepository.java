package com.project.chatrealtime_backend.repository;

import com.project.chatrealtime_backend.model.Message;
import com.project.chatrealtime_backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
