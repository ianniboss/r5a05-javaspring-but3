package com.example.demo.repositories;

import com.example.demo.models.Joueur;
import org.springframework.data.repository.CrudRepository;

public interface JoueurRepository extends CrudRepository<Joueur, Long> {
}