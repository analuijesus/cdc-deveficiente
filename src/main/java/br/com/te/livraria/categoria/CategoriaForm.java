package br.com.te.livraria.categoria;


import br.com.te.livraria.uteis.validacao.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria toModel() {
        return new Categoria(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
