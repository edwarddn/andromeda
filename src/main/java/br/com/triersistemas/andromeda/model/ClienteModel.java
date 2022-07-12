package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.helper.CpfUtils;
import br.com.triersistemas.andromeda.helper.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class ClienteModel {

    private UUID id;

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

    public ClienteModel(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.niver = cliente.getNiver();
        this.email = cliente.getEmail();
        this.cpf = cliente.getDocumento();
    }

    public boolean getDocumentoValido() {
        final List<Integer> digitos = StringUtils.extractNumbersToList(this.cpf);
        if (digitos.size() == 11 && digitos.stream().distinct().count() > 1) {
            return CpfUtils.geraCpf(digitos.subList(0, 9)).equals(this.cpf);
        }
        return false;
    }

    public String getDocumento() {
        if (this.cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }

    public Long getIdade() {
        return Objects.nonNull(niver) ? ChronoUnit.YEARS.between(niver, LocalDate.now()) : 0L;
    }

}
