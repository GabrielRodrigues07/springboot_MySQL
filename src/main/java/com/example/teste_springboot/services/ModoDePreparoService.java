package com.example.teste_springboot.services;

import com.example.teste_springboot.entities.ModoDePreparo;
import com.example.teste_springboot.entities.Receita;
import com.example.teste_springboot.error.ResourceNotFoundException;
import com.example.teste_springboot.repositories.ModoDePreparoRepository;
import com.example.teste_springboot.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModoDePreparoService {

    @Autowired
    private ModoDePreparoRepository repository;

    public List<ModoDePreparo> findAll() {
        return repository.findAll();
    }

    public ModoDePreparo findById(Long id) {
        Optional<ModoDePreparo> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("ModoDePreparo não encontrado, ID: " + id));
    }

    public ModoDePreparo insert(ModoDePreparo obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ModoDePreparo update(ModoDePreparo obj) {
        return repository.save(obj);
    }
}
