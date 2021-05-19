package com.example.teste_springboot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int tempoPreparo;

    @OneToOne
    private ModoDePreparo modoDePreparo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingrediente")
    private List<Ingrediente> ingredientes;

    public Receita() {
    }

    public Receita(Long id, String nome, int tempoPreparo) {
        this.id = id;
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return Objects.equals(id, receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
