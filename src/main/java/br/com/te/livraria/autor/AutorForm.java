package br.com.te.livraria.autor;

import br.com.te.livraria.uteis.validacao.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record AutorForm(@NotBlank String nome, @Email @NotBlank @UniqueValue(domainClass = Autor.class, fieldName = "email") String email, @Length(min = 5, max = 400) String descricao) {

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }

    @Override
    public String email() {
        return email;
    }
}
