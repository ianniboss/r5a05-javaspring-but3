package com.example.demo.controllers;

import com.example.demo.models.Equipe;
import com.example.demo.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public Iterable<Equipe> getEquipes() {
        return equipeRepository.findAll();
    }

    @PostMapping
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}