package br.com.te.livraria.endereco.pais;

import br.com.te.livraria.uteis.validacao.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public record PaisForm(@UniqueValue(fieldName = "nome", domainClass = Pais.class) @NotBlank String nome) {
    public Pais toModel() {
        return new Pais(nome);
    }
}
