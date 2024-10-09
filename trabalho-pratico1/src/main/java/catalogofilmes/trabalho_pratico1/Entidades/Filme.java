package com.catalogofilmes.trabalho_pratico1.Entidades;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;


@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int ano;

    @ManyToMany
    private Set<Ator> atores = new HashSet<>();

    @ManyToMany
    private Set <Genero> genero = new HashSet<>();

    public Long getId(){
        return id;
    }

    public Long setId(Long id){
        this.id=id;
    }

    
    



}
