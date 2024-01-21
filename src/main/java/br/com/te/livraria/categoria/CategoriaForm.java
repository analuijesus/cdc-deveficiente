package br.com.te.livraria.categoria;

import br.com.te.livraria.uteis.validacao.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public record CategoriaForm(@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome") String nome) {

    public Categoria toModel() {
        return new Categoria(nome);
    }
}