package com.project.chatrealtime_backend;

import com.project.chatrealtime_backend.model.Message;
import com.project.chatrealtime_backend.model.Room;
import com.project.chatrealtime_backend.repository.MessageRepository;
import com.project.chatrealtime_backend.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RoomRepository roomRepository, MessageRepository messageRepository) {
        return args -> {
//            log.info("Preloading room: " + roomRepository.save(new Room(1,"Admin",false)));
//            log.info("Preloading message: " + messageRepository.save(new Message("Admin",1,"First message",1)));
        };
    }
}