package com.example.teste_springboot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingrediente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Timestamp inclusao;
    private Timestamp alteracao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_receita")
    private List<Receita> receitas;

    public Ingrediente() {
    }

    public Ingrediente(Long id, String nome, Timestamp inclusao, Timestamp alteracao, Unidade unidade) {
        this.id = id;
        this.nome = nome;
        this.inclusao = inclusao;
        this.alteracao = alteracao;
        this.unidade = unidade;
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
