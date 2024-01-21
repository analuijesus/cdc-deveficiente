package br.com.te.livraria.livro;

import br.com.te.livraria.autor.Autor;
import br.com.te.livraria.autor.AutorRepository;
import br.com.te.livraria.categoria.Categoria;
import br.com.te.livraria.categoria.CategoriaRepository;
import br.com.te.livraria.uteis.validacao.UniqueValue;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroForm(
        @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo") String titulo,
        @NotBlank @Size(max = 500) String resumo,
        String sumario,
        @Min(20) BigDecimal preco,
        @Min(100) int numeroDePaginas,
        @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn") String isbn,
        @Future LocalDate dataPublicacao,
        @NotNull Long categoriaId,
        @NotNull Long autorId
) {

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        @NotNull Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow();
        @NotNull Autor autor = autorRepository.findById(autorId).orElseThrow();

        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, categoria, autor);
    }
}
