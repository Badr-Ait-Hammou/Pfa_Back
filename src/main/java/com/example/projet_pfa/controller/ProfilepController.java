package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Profile;
import com.example.projet_pfa.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/profiles")
@CrossOrigin
public class ProfilepController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/user/{id}")
    public Profile findProfileByUserId(@PathVariable int id) {
        return profileService.findProfileByUserId(id);
    }



    @PostMapping("/")
    public Profile save(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @GetMapping("/")
    public List<Profile> findAll() {
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public Profile findById(@PathVariable int id) {
        return profileService.findById(id);
    }


    public void delete(Profile o) {
        profileService.delete(o);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Profile profileinfo) {
        profileService.update(id, profileinfo);
    }


}
