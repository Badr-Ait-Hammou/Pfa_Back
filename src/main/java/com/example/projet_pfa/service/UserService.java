package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Dao<User> {


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(User o) {

    }
    public void update(Integer id,User userinfo) {
        User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        user.setFirstName(userinfo.getFirstName());
        user.setLastName(userinfo.getLastName());
        user.setAdresse(userinfo.getAdresse());
        user.setArea(userinfo.getArea());
        user.setPhoto(userinfo.getPhoto());
        user.setTelephone(userinfo.getTelephone());
        user.setPostcode(userinfo.getPostcode());
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        userRepository.delete(user);
    }

}
