package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThymeleafController {

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("username", "龚赞");
        model.addAttribute("password", "123456");
        return "show";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(){
        return "addUser";
    }
}
