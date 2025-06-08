package com.example.messageboard.controller;

import com.example.messageboard.entity.Message;
import com.example.messageboard.entity.User;
import com.example.messageboard.service.MessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/list")
    public String listMessages(Model model, HttpSession session) {
        model.addAttribute("messages", messageService.findAll());
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        return "message/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        model.addAttribute("message", new Message());
        return "message/add";
    }

    @PostMapping("/add")
    public String addMessage(@ModelAttribute Message message, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        message.setUser(loggedInUser);
        messageService.save(message);
        return "redirect:/message/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"admin".equals(loggedInUser.getUsername())) {
            return "redirect:/message/list"; // 非管理员无权限，重定向回列表
        }
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "message/edit";
    }

    @PostMapping("/edit")
    public String updateMessage(@ModelAttribute Message message, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"admin".equals(loggedInUser.getUsername())) {
            return "redirect:/message/list"; // 非管理员无权限，重定向回列表
        }
        // 从数据库获取现有留言，只更新内容，保持原有用户和发布时间
        Message existingMessage = messageService.findById(message.getId());
        existingMessage.setContent(message.getContent());
        messageService.save(existingMessage);
        return "redirect:/message/list";
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public String deleteMessage(@PathVariable Long id, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        boolean isAdmin = (loggedInUser != null && "admin".equals(loggedInUser.getUsername()));
        
        if (isAdmin) {
            messageService.deleteById(id);
            return "success";
        } else {
            return "不是管理员用户，无法删除留言";
        }
    }
} 