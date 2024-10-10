package com.catalogofilmes.trabalho_pratico1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    
    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);

    //
    
    public Optional<Filme> buscarPorId(Long id){
        return filmeRepository.findAllById(id);
    }

    }
}
