package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Profile;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements Dao<Profile> {

    public Profile findProfileByUserId(int id) {
        return profileRepository.findProfileByUserId(id);
    }

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile save(Profile profile)  {
        if(profileRepository.findProfileByUserId(profile.getUser().getId())==null){
            return profileRepository.save(profile);
        }else
            return null;
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(int id) {
        return profileRepository.findById(id);
    }

    @Override
    public void delete(Profile o) {

    }
    public void update(Integer id, Profile profileinfo) {
        Profile profile=profileRepository.findProfileByUserId(id);
        profile.setEmail(profileinfo.getEmail());
        profile.setFullName(profileinfo.getFullName());
        profile.setFirstAdresse(profileinfo.getFirstAdresse());
        profile.setSecondAdresse(profileinfo.getSecondAdresse());
        profile.setPhoneNumber(profileinfo.getPhoneNumber());
        profile.setArea(profileinfo.getArea());
        profile.setPostCode(profileinfo.getPostCode());
        profile.setPhoto(profileinfo.getPhoto());
        profileRepository.save(profile);
    }
}
