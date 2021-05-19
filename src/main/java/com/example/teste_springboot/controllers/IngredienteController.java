package com.example.teste_springboot.controllers;

import com.example.teste_springboot.entities.Ingrediente;
import com.example.teste_springboot.entities.Unidade;
import com.example.teste_springboot.error.ResourceNotFoundException;
import com.example.teste_springboot.services.IngredienteService;
import com.example.teste_springboot.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById (@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Ingrediente ingrediente) {
        return new ResponseEntity<>(service.insert(ingrediente), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfNotExists(id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Ingrediente ingrediente) {
        verifyIfNotExists(ingrediente.getId());
        service.update(ingrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfNotExists(Long id) {
        if (service.findById(id) == null)
            throw new ResourceNotFoundException("Ingrediente não encontrado, ID: " + id);
    }
}
