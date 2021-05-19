package com.example.teste_springboot.repositories;

import com.example.teste_springboot.entities.Ingrediente;
import com.example.teste_springboot.entities.ModoDePreparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoDePreparoRepository extends JpaRepository<ModoDePreparo, Long> {
}
