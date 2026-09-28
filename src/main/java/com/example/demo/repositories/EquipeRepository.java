package com.example.demo.repositories;

import com.example.demo.models.Equipe;
import org.springframework.data.repository.CrudRepository;

public interface EquipeRepository extends CrudRepository<Equipe, Long> {
}