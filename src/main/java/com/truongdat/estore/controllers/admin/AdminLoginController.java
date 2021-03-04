package com.truongdat.estore.controllers.admin;

import com.truongdat.estore.dto.LoginDTO;
import com.truongdat.estore.forms.LoginForm;
import com.truongdat.estore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdminLoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/login")
    public String getAdminLogin(final Model model) {
        model.addAttribute("loginForm", new LoginDTO());
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String postAdminLogin(@Valid @ModelAttribute("loginForm") final LoginDTO loginForm,
                                 BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "admin/login";
        }
        if (userService.login(loginForm) != null) {
            session.setAttribute("loginUser", loginForm.getUsername());
            return "redirect:/admin/categories";
        }
        //username: field, s1: errorCode, s2: defaultMessage
        bindingResult.rejectValue("username", "User or password is invalid", "User or password is invalid");
        return "admin/login";
    }
}
