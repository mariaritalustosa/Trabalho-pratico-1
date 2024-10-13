package com.catalogofilmes.trabalho_pratico1;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    private GeneroRepository generoRepository;
    private DiretorRepository diretorRepository;
    
    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public List <Filme> listarFilmes(){
        return filmeRepository.findAll();
    }
    public Optional<Filme> buscarFilmePorId(Long id) {
        return filmeRepository.findById(id);
    }
    
    public void removerFilme(Long id){
       filmeRepository.deleteById(id);
    }
    public Diretor buscarDiretorPorNome(String nome) {
        return diretorRepository.findByNome(nome); 
    }
    
    public Genero buscarGeneroPorNome(String nome) {
        return generoRepository.findByNome(nome); 
    }
    

}
