package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

@MappedSuperclass
public abstract class PessoaFisica extends Pessoa {

    private String cpf;

    protected PessoaFisica() {
        SplittableRandom r = new SplittableRandom();
        List<Integer> digitos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            digitos.add(r.nextInt(0, 10));
        }
        this.cpf = this.geraCpf(digitos);
    }

    protected PessoaFisica(final String nome, final LocalDate niver, final String cpf) {
        super(nome, niver);
        this.cpf = StringUtils.extractNumbers(cpf);
    }

    public PessoaFisica editar(final String nome, final LocalDate niver, final String cpf) {
        super.editar(nome, niver);
        this.cpf = StringUtils.extractNumbers(cpf);
        return this;
    }

    private String geraCpf(final List<Integer> digitos) {
        digitos.add(super.mod11(digitos, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        digitos.add(super.mod11(digitos, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        return StringUtils.listToString(digitos);
    }

    @Override
    public boolean getDocumentoValido() {
        final List<Integer> digitos = StringUtils.extractNumbersToList(this.cpf);
        if (digitos.size() == 11 && digitos.stream().distinct().count() > 1) {
            return geraCpf(digitos.subList(0, 9)).equals(this.cpf);
        }
        return false;
    }

    @Override
    public String getDocumento() {
        if (this.cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }
}
