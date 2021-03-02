package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger log = LoggerFactory.getLogger(UserService.class);

    /**
     * 根据id查询用户信息
     * @return
     */
    public User getUserById(int id){
        User user = userRepository.getOne(id);
        log.info("UserService-getUserById,根据id查询用户,用户json：{}", user);
        return user;
    }

    /**
     * 添加用户
     */
    public void addUser(User user){
        userRepository.save(user);
        log.info("UserService-addUser,添加用户,用户json：{}", user);
    }

    /**
     * 删除用户
     */
    public void deleteUser(int id){
        userRepository.deleteById(id);
        log.info("UserService-deleteUser,删除用户,用户id：{}", id);
    }

    /**
     * 查询所有用户信息
     */
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        log.info("UserService-getAllUsers,获取全部用户,用户json：{}", users);
        return users;
    }

    /**
     * 更新用户
     */
    public void updateUser(User user){
        userRepository.save(user);
        log.info("UserService-deleteUser,修改用户,用户json：{}", user);
    }
}
