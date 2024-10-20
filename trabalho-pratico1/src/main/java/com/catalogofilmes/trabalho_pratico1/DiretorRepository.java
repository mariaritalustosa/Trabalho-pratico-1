package com.catalogofilmes.trabalho_pratico1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    Diretor findByNome(String nome);
}
