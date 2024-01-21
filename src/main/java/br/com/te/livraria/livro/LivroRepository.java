package br.com.te.livraria.livro;

import br.com.te.livraria.livro.detalhesLivro.LivroIdComTituloProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select l.id as id, l.titulo as titulo from Livro l")
    List<LivroIdComTituloProjection> getLivroIdComTitulo();

}