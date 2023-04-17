package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Dao<User> {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User o) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void delete(User o) {

    }
    public void update(Integer id,User userinfo) {
        User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        user.setEmail(userinfo.getEmail());
        user.setNom(userinfo.getNom());
        user.setPrenom(userinfo.getPrenom());
        user.setPassword(userinfo.getPassword());
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        userRepository.delete(user);
    }
}
