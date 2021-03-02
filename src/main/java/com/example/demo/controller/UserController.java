package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user){
        userService.addUser(user);
        log.info("UserController-addUser,添加用户,用户json:{}", user);
        return "success add";
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(int id){
        userService.deleteUser(id);
        log.info("UserController-deleteUser,删除用户");
        return "success delete";
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(User user) {
        userService.updateUser(user);
        log.info("UserController-updateUser,更新用户");
        return "update success";
    }

    @RequestMapping("/")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        log.info("UserController-getAllUsers,获取全部用户,用户json:{}", users);
        return "usersList";
    }

    @RequestMapping("getUserById")
    public String getUserById(int id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        log.info("UserController-getUserById,根据id获取用户,id:{}", id);
        return "updateUser";
    }

}
