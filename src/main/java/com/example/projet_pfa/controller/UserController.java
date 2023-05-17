package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controller/users")
@CrossOrigin
public class UserController {


    @GetMapping("/email/{email}")
    public Optional<User> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

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
