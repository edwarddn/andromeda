package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public abstract class PessoaJuridica extends Pessoa {

    private String cnpj;

    protected PessoaJuridica() {
        SplittableRandom r = new SplittableRandom();
        List<Integer> digitos = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            digitos.add(r.nextInt(0, 10));
        }
        this.cnpj = this.geraCnpj(digitos);
    }

    protected PessoaJuridica(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver);
        this.cnpj = StringUtils.extractNumbers(cnpj);
    }

    public void editar(final String nome, final LocalDate niver, final String cnpj) {
        super.editar(nome, niver);
        this.cnpj = StringUtils.extractNumbers(cnpj);
    }

    private String geraCnpj(final List<Integer> digitos) {
        digitos.add(super.mod11(digitos, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9));
        digitos.add(super.mod11(digitos, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9));
        return StringUtils.listToString(digitos);
    }

    @Override
    public String getDocumento() {
        if (this.cnpj.length() == 14) {
            return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        }
        return cnpj;
    }

    @Override
    public boolean getDocumentoValido() {
        final List<Integer> digitos = StringUtils.extractNumbersToList(this.cnpj);
        if (digitos.size() == 14 && digitos.stream().distinct().count() > 1) {
            return geraCnpj(digitos.subList(0, 12)).equals(this.cnpj);
        }
        return false;
    }
}
