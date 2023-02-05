package com.project.chatrealtime_backend;

import org.springframework.data.jpa.repository.JpaRepository;

interface MessageRepository extends JpaRepository<Room, Integer> {
}
