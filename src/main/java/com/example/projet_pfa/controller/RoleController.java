package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Role;
import com.example.projet_pfa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @GetMapping("/")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable int id) {
        return roleService.findById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Role roleinfo) {
        roleService.update(id, roleinfo);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
    }

}
