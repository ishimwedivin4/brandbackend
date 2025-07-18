package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.ContactMessage;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    // Create or Update Contact Message
    public ContactMessage saveMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }

    // Get All Contact Messages
    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    // Get Messages by User
    public List<ContactMessage> getMessagesByUser(User user) {
        return contactMessageRepository.findByUser(user);
    }

    // Get Messages by Email
    public List<ContactMessage> getMessagesByEmail(String email) {
        return contactMessageRepository.findByEmail(email);
    }

    // Get Message by ID
    public ContactMessage getMessageById(Long id) {
        return contactMessageRepository.findById(id).orElse(null);
    }

    // Delete Message by ID
    public void deleteMessage(Long id) {
        contactMessageRepository.deleteById(id);
    }
}
