package com.catalogofilmes.trabalho_pratico1;

import java.util.*;
import jakarta.persistence.*;


@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Long ano;

    @ManyToOne
    @JoinColumn(name = "diretor_id", referencedColumnName = "id")
    private Diretor diretor;

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

    public Filme() {}

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

    public Long getAno(){
        return ano;
    }

    public void setAno(Long ano){
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

    public void setDiretor(Diretor diretor2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDiretor'");
    }

}
