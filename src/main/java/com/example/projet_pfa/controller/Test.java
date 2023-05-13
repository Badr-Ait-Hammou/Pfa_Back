package com.example.projet_pfa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/controller")
//@PreAuthorize("hasRole('ADMIN')")
public class Test {

    @GetMapping("/test")

    //@PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("done");
    }
}
