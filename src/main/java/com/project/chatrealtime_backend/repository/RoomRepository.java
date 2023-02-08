package com.project.chatrealtime_backend.repository;

import com.project.chatrealtime_backend.model.Room;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "select * from room where (?1 is null or new_mess = ?1) and (?2 is null or name = ?2) limit ?3", nativeQuery = true)
    List<Room> findCustom(Boolean newMess, String name, Integer limit);
}
