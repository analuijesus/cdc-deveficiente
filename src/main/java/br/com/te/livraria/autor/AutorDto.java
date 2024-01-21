package br.com.te.livraria.autor;

public class AutorDto {
    private String nome;
    private String descricao;

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
