package com.truongdat.estore.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLogoutController {
    @GetMapping("/logout")
    public String getAdminLogin(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/admin/login";
    }
}
