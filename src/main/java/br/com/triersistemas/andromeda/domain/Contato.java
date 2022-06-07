package br.com.triersistemas.andromeda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Contato {
    private String nome;
    private LocalDateTime dataCadastro;

    public Contato(final String nome) {
        this.nome = nome;
        this.dataCadastro = LocalDateTime.now();
    }
}
