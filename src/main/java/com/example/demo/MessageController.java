package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/messages")
    public String view(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "messages";
    }

    @PostMapping("/messages")
    public String add(@RequestParam String content) {
        if (content != null && !content.trim().isEmpty()) {
            Message msg = new Message();
            msg.setContent(content.trim());

            msg.setCreatedAt(new Date());
            
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();

            msg.setUser(accountRepository.findByUsername(username));
            messageRepository.save(msg);
        }

        return "redirect:/messages";
    }
    @GetMapping("/messages/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Message message = messageRepository.findById(id).orElse(null);
        model.addAttribute("message", message);
        return "editMessage"; // Create a new Thymeleaf template for editing
    }

    @PostMapping("/messages/edit/{id}")
    public String edit(@PathVariable Long id, @RequestParam String content) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message != null) {
            message.setContent(content);
            messageRepository.save(message);
        }
        return "redirect:/messages";
    }
    @PostMapping("/messages/delete/{id}")
    public String delete(@PathVariable Long id) {
        // Tässä voit käyttää messageRepository.deleteById(id) tai vastaavaa
        messageRepository.deleteById(id);
        return "redirect:/messages";
    }
}