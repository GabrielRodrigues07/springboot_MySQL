package com.example.teste_springboot.controllers;

import com.example.teste_springboot.entities.Ingrediente;
import com.example.teste_springboot.entities.ModoDePreparo;
import com.example.teste_springboot.error.ResourceNotFoundException;
import com.example.teste_springboot.services.IngredienteService;
import com.example.teste_springboot.services.ModoDePreparoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modo_preparo")
public class ModoDePreparoController {

    @Autowired
    private ModoDePreparoService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById (@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ModoDePreparo modoDePreparo) {
        return new ResponseEntity<>(service.insert(modoDePreparo), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfNotExists(id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ModoDePreparo modoDePreparo) {
        verifyIfNotExists(modoDePreparo.getId());
        service.update(modoDePreparo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfNotExists(Long id) {
        if (service.findById(id) == null)
            throw new ResourceNotFoundException("ModoDePreparo não encontrado, ID: " + id);
    }
}
