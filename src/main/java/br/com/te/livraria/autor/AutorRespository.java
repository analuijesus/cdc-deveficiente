package br.com.te.livraria.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRespository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);
}
