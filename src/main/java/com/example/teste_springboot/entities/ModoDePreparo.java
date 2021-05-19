package com.example.teste_springboot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ModoDePreparo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ordem;
    private String preparo;
    @OneToOne
    @JoinColumn(name = "id_receita")
    private Receita receita;

    public ModoDePreparo() {
    }

    public ModoDePreparo(Long id, int ordem, String preparo, Receita receita) {
        this.id = id;
        this.ordem = ordem;
        this.preparo = preparo;
        this.receita = receita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModoDePreparo that = (ModoDePreparo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
