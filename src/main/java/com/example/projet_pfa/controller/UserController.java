package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody User user) {
         userService.save(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }




    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody User userinfo) {
        userService.update(id, userinfo);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


}
