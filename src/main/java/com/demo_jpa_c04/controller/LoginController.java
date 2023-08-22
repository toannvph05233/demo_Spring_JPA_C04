package com.demo_jpa_c04.controller;

import com.demo_jpa_c04.model.Account;
import com.demo_jpa_c04.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Account account = accountService.login(username, password);
        if (account != null) {
            session.setAttribute("account", account);
            return "redirect:/products/home";
        }
        return "login";
    }
}
