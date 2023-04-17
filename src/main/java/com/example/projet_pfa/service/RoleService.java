package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Role;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements Dao<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role o) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public void delete(Role o) {

    }

    public void update(Integer id,Role roleinfo) {
        Role role=roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("role not found with id " + id));
        role.setNom(roleinfo.getNom());
        role.setUserList(roleinfo.getUserList());
        roleRepository.save(role);

    }

    public void deleteRole(Integer id){
        Role role= roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("role not found with id " + id));
        roleRepository.delete(role);
    }
}
