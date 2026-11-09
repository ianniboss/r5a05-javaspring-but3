package com.example.demo.controllers;

import com.example.demo.models.Joueur;
import com.example.demo.repositories.EquipeRepository;
import com.example.demo.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public Iterable<Joueur> getJoueurs() {
        return joueurRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        return joueurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipe/{equipeId}")
    public Iterable<Joueur> getJoueursByEquipe(@PathVariable Long equipeId) {
        return joueurRepository.findByEquipeId(equipeId);
    }

    @PostMapping
    public Joueur addJoueur(@RequestBody Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @RequestBody Joueur details) {
        return joueurRepository.findById(id)
                .map(joueur -> {
                    joueur.setNom(details.getNom());
                    joueur.setPrenom(details.getPrenom());
                    joueur.setPoste(details.getPoste());
                    joueur.setActif(details.isActif());
                    joueur.setEquipe(details.getEquipe());
                    return ResponseEntity.ok(joueurRepository.save(joueur));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        if (!joueurRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        joueurRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

