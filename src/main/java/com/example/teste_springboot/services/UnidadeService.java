package com.example.teste_springboot.services;

import com.example.teste_springboot.entities.Unidade;
import com.example.teste_springboot.error.ResourceNotFoundException;
import com.example.teste_springboot.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository repository;

    public List<Unidade> findAll() {
        return repository.findAll();
    }

    public Unidade findById(Long id) {
        Optional<Unidade> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Unidade não encontrada, ID: " + id));
    }

    public Unidade insert(Unidade obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Unidade update(Unidade obj) {
        return repository.save(obj);
    }
}
