package com.example.hotelmanagementsystem.controllers;

import com.example.hotelmanagementsystem.models.User;
import com.example.hotelmanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class loginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(){
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model){
        model.addAttribute(new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegisterForm(Model model, @Valid User user, BindingResult errors){
        User userExists = userService.findByUsername(user.getUsername());

        if (userExists != null){
//            errors.reject("username");
            errors.rejectValue("username", "username.notvalid", "Użytkownik o takiej nazwie już istnieje");
        }

        if (errors.hasErrors()){
            model.addAttribute(user);
            return "register";
        }

        userService.save(user);

        return "login";
    }
}
