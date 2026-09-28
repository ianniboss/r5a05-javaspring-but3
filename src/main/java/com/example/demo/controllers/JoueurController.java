package com.example.demo.controllers;

import com.example.demo.models.Joueur;
import com.example.demo.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @GetMapping
    public Iterable<Joueur> getJoueurs() {
        return joueurRepository.findAll();
    }

    @PostMapping
    public Joueur addJoueur(@RequestBody Joueur joueur) {
        return joueurRepository.save(joueur);
    }
}
