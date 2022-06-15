package br.com.triersistemas.andromeda.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class ClienteModel {

    @NotNull
    @NotBlank
    @Length(min = 2, max = 30)
    private String nome;

    @NotNull(message = "A data de aniversário não pode ser nula")
    private LocalDate niver;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cpf;
}
