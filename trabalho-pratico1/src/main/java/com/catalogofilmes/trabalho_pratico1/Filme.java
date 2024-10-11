package com.catalogofilmes.trabalho_pratico1;
import java.util.*;

import jakarta.persistence.*;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int ano;

    @ManyToMany
    @JoinTable(
        name = "filme_ator",
        joinColumns = @JoinColumn(name = "filme_id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id")
    )
    private List<Ator> atores = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "genero_filme",
        joinColumns = @JoinColumn(name = "filme_id"),
        inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public List<Ator> getAtores(){
        return atores;
    }

    public void setAtores(List<Ator> atores){
        this.atores = atores;
    }

    public List<Genero> getGeneros(){
        return generos;
    }

    public void setGeneros(List<Genero> generos){
        this.generos = generos;
    }

}
