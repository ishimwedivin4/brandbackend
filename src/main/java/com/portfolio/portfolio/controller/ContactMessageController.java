package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.ContactMessage;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    // Create or Update Contact Message
    @PostMapping
    public ContactMessage createOrUpdateMessage(@RequestBody ContactMessage contactMessage) {
        return contactMessageService.saveMessage(contactMessage);
    }

    // Get All Contact Messages
    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageService.getAllMessages();
    }

    // Get Messages by User
    @GetMapping("/user/{userId}")
    public List<ContactMessage> getMessagesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // Fetch the user by ID
        return contactMessageService.getMessagesByUser(user);
    }

    // Get Messages by Email
    @GetMapping("/email/{email}")
    public List<ContactMessage> getMessagesByEmail(@PathVariable String email) {
        return contactMessageService.getMessagesByEmail(email);
    }

    // Get Message by ID
    @GetMapping("/{id}")
    public ContactMessage getMessageById(@PathVariable Long id) {
        return contactMessageService.getMessageById(id);
    }

    // Delete Message by ID
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        contactMessageService.deleteMessage(id);
    }
}
