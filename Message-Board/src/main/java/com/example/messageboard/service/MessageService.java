package com.example.messageboard.service;

import com.example.messageboard.entity.Message;
import com.example.messageboard.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message findById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("留言不存在"));
    }

    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
} 