package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Fornecedor extends PessoaJuridica {

    private List<String> produtos;

    public Fornecedor() {
        this.produtos = StringUtils.getRandomMeds();
    }

    public Fornecedor(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver, cnpj);
        this.produtos = StringUtils.getRandomMeds();
    }

    public List<String> getProdutos() {
        return produtos;
    }
}
