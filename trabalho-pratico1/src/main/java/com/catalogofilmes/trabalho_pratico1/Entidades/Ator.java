package com.catalogofilmes.trabalho_pratico1.Entidades;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "atores")
    private Set<Filme> filmes = new HashSet<>();

    public Ator(){
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

    public Set<Filme> getFilmes(){
        return filmes;
    }
    public void setFilmes(Set<Filme> filmes){
        this.filmes = filmes;
    }
}
