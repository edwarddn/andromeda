package br.com.triersistemas.andromeda.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Fornecedor extends PessoaJuridica {

    private List<String> produtos;

    public Fornecedor() {
        geraProdutos();
    }

    public Fornecedor(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver, cnpj);
        geraProdutos();
    }

    public List<String> getProdutos() {
        return produtos;
    }

    private void geraProdutos() {
        this.produtos = new ArrayList<>();
        List<String> lista = new ArrayList<>();
        lista.add("Dipirona");
        lista.add("Frauda Anjinho");
        lista.add("Dove my care");
        lista.add("Trident");
        lista.add("Paracetamol");
        lista.add("Rivotril");
        lista.add("Cloridrato de paroxetina");
        lista.add("Valium");
        lista.add("Valeriana");
        lista.add("Floral");
        lista.add("Dramin");

        var r = new SplittableRandom();

        for (int i = 0; i < r.nextInt(2, lista.size()); i++) {
            var p = lista.get(r.nextInt(0, lista.size()));
            this.produtos.add(p);
            lista.remove(p);
        }
    }
}
