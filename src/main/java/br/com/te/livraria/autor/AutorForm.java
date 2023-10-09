package br.com.te.livraria.autor;

import br.com.te.livraria.uteis.validacao.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class AutorForm {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @Length(min = 5, max = 400)
    private String descricao;

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }
}
