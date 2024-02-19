package br.com.te.livraria.endereco.pais;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() { }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                '}';
    }
}