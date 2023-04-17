package com.example.projet_pfa.controller;

import com.example.projet_pfa.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avis")
public class AvisController {
    @Autowired
    private AvisService avisService;
}
