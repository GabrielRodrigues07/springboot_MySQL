package com.example.teste_springboot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private Timestamp inclusao;
    private Timestamp alteracao;

    @OneToMany
    private List<Ingrediente> ingredientes;

    public Unidade() {
    }

    public Unidade(Long id, String descricao, Timestamp inclusao, Timestamp alteracao) {
        this.id = id;
        this.descricao = descricao;
        this.inclusao = inclusao;
        this.alteracao = alteracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getInclusao() {
        return inclusao;
    }

    public void setInclusao(Timestamp inclusao) {
        this.inclusao = inclusao;
    }

    public Timestamp getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(Timestamp alteracao) {
        this.alteracao = alteracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unidade unidade = (Unidade) o;
        return Objects.equals(id, unidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
