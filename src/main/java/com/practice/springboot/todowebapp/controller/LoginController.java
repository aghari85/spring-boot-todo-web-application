package com.practice.springboot.todowebapp.controller;

import com.practice.springboot.todowebapp.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap){
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String showWelcomePage(ModelMap modelMap, @RequestParam String name, @RequestParam String password){
        boolean isValidUser = loginService.validateUser(name,password);
        if(!isValidUser){
            modelMap.put("errorMessage","invalid credentials");
            return "login";
        }
        modelMap.put("name", name);
        return "welcome";
    }
}
