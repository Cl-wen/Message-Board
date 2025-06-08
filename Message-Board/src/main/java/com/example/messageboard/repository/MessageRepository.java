package com.example.messageboard.repository;

import com.example.messageboard.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
} 