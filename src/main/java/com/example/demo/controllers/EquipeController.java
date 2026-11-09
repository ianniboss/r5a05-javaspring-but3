package com.example.demo.controllers;

import com.example.demo.models.Equipe;
import com.example.demo.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        return equipeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe details) {
        return equipeRepository.findById(id)
                .map(equipe -> {
                    equipe.setNom(details.getNom());
                    equipe.setVille(details.getVille());
                    return ResponseEntity.ok(equipeRepository.save(equipe));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        if (!equipeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        equipeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
