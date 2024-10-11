package com.catalogofilmes.trabalho_pratico1;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes = new ArrayList<>();

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

    public List<Filme> getFilmes(){
        return filmes;
    }
    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
    }
}
