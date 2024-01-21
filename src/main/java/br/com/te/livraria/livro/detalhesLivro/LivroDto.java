package br.com.te.livraria.livro.detalhesLivro;

import br.com.te.livraria.autor.AutorDto;
import br.com.te.livraria.categoria.CategoriaDto;
import br.com.te.livraria.livro.Livro;

import java.time.LocalDate;

public class LivroDto {

    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final String isbn;
    private final LocalDate dataPublicacao;
    private final AutorDto autor;
    private final CategoriaDto categoria;

    public LivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new AutorDto(livro.getAutor());
        this.categoria = new CategoriaDto(livro.getCategoria());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }
}
