package com.project.chatrealtime_backend;

import org.springframework.data.jpa.repository.JpaRepository;

interface RoomRepository extends JpaRepository<Room, Long> {
}
