package com.example.teste_springboot.services;

import com.example.teste_springboot.entities.Ingrediente;
import com.example.teste_springboot.entities.Unidade;
import com.example.teste_springboot.error.ResourceNotFoundException;
import com.example.teste_springboot.repositories.IngredienteRepository;
import com.example.teste_springboot.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository repository;

    public List<Ingrediente> findAll() {
        return repository.findAll();
    }

    public Ingrediente findById(Long id) {
        Optional<Ingrediente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Ingrediente não encontrado, ID: " + id));
    }

    public Ingrediente insert(Ingrediente obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Ingrediente update(Ingrediente obj) {
        return repository.save(obj);
    }
}
