package com.catalogofilmes.trabalho_pratico1;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Long ano;

    @ManyToMany
    @JoinTable(
        name = "filme_genero",
        joinColumns = @JoinColumn(name = "filme_id"),
        inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos; 

    private String diretor;

    public Filme() {}

    public Filme(String titulo, Long ano, List<Genero> generos, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.generos = generos; 
        this.diretor = diretor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public List<Genero> getGeneros() {
        return generos; 
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos; 
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
