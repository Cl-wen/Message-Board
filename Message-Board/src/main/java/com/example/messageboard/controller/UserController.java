package com.example.messageboard.controller;

import com.example.messageboard.entity.User;
import com.example.messageboard.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "message/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/";
        } else {
            model.addAttribute("error", "用户名或密码不正确");
            return "message/login";
        }
    }

    @GetMapping("/register")
    public String registerForm() {
        return "message/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        if (userService.existsByUsername(username)) {
            model.addAttribute("error", "用户名已存在");
            return "message/register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);

        return "redirect:/login?registered";
    }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 使会话无效
        return "redirect:/";
    }
} 