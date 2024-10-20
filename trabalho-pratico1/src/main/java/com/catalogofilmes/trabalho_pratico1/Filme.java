package com.catalogofilmes.trabalho_pratico1;
import jakarta.persistence.*;


@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Long ano;
    private String genero;
    private String diretor;

    public Filme() {}

    public Filme(String titulo, Long ano, String genero, String diretor){
        this.titulo = titulo;
        this.ano= ano;
        this.genero = genero;
        this.diretor = diretor;
    }

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
        this.titulo=titulo;
    }

    public Long getAno(){
        return ano;
    }

    public void setAno(Long ano){
        this.ano = ano;
    }

    public String getGenero(){
        return genero;
    }

    public void setGeneros(String genero){
        this.genero = genero;
    }

    public String getDiretor(){
        return diretor;
    }

    public void setDiretor(String diretor){
        this.diretor=diretor;
    }

}
