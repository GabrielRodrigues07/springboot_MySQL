package com.example.teste_springboot.services;

import com.example.teste_springboot.entities.Receita;
import com.example.teste_springboot.entities.Unidade;
import com.example.teste_springboot.error.ResourceNotFoundException;
import com.example.teste_springboot.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    public List<Receita> findAll() {
        return repository.findAll();
    }

    public Receita findById(Long id) {
        Optional<Receita> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada, ID: " + id));
    }

    public Receita insert(Receita obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Receita update(Receita obj) {
        return repository.save(obj);
    }
}
