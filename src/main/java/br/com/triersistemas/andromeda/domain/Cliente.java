package br.com.triersistemas.andromeda.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Cliente extends PessoaFisica {

    private String email;

    public Cliente(final String nome,
                   final LocalDate niver,
                   final String cpf,
                   final String email) {
        super(nome, niver, cpf);
        this.email = email;
    }

    public Cliente editar(final String nome,
                          final LocalDate niver,
                          final String cpf,
                          final String email) {
        super.editar(nome, niver, cpf);
        this.email = email;
        return this;
    }
}
