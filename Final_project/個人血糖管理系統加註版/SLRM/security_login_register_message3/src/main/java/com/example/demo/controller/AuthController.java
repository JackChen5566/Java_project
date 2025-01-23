package com.example.demo.controller;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private MessageService messageService;
    
    @PostMapping("/messages")
    public String postMessage(@AuthenticationPrincipal UserDetails userDetails, @RequestParam String content) {
        messageService.saveMessage(userDetails.getUsername(), content);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new RegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<Message> messages = messageService.getAllMessages();
        if (messages == null) {
            messages = new ArrayList<>();
        }
        Collections.reverse(messages);
        model.addAttribute("messages", messages);
        model.addAttribute("isAdmin", userDetails != null && userDetails.getUsername().equals("admin99"));
        return "home";
    }

    @PostMapping("/messages/delete")
    public String deleteMessage(@RequestParam Long id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null && userDetails.getUsername().equals("admin99")) {
            messageService.deleteMessage(id);
        }
        return "redirect:/";
    }

    @GetMapping("/messages/edit")
    public String editMessage(@RequestParam Long id, Model model) {
        Message message = messageService.getMessageById(id);
        model.addAttribute("message", message);
        return "editMessage";
    }
    

    @PostMapping("/messages/update")
    public String updateMessage(@RequestParam Long id, @RequestParam String content) {
        messageService.updateMessage(id, content);
        return "redirect:/";
    }

    @PostConstruct
    public void init() {
        if (userService.findByUsername("admin99") == null) {
            User admin = new User();
            admin.setUsername("admin99");
            admin.setPassword("admin99");
            admin.setEmail("admin@demo.com");
            admin.setRole("ADMIN");
            userService.saveUser(admin);
        }
    }
}
