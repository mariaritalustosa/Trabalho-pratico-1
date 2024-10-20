package com.catalogofilmes.trabalho_pratico1;
import java.util.*;

import jakarta.persistence.*;
@Entity
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private Long id;

    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes;

    public Diretor(){
        
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Filme> getFilmes(){
        return filmes;
    }

    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
    }
}