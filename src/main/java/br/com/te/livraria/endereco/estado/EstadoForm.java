package br.com.te.livraria.endereco.estado;

import br.com.te.livraria.endereco.pais.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstadoForm(@NotBlank String nome, @NotNull Long paisId) {
    public Estado toModel(PaisRepository paisRepository) {
        @NotNull Pais pais = paisRepository.findById(paisId).orElseThrow();
        return new Estado(nome, pais);
    }
}
