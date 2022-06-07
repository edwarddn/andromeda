package br.com.triersistemas.andromeda.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Farmaceutico extends PessoaFisica {

    private String ofertaDia;

    public Farmaceutico() {
        geraOferta();
    }

    public Farmaceutico(final String nome, final LocalDate niver, final String cpf) {
        super(nome, niver, cpf);
        geraOferta();
    }

    public String getOfertaDia() {
        return ofertaDia;
    }

    private void geraOferta() {
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

        this.ofertaDia = lista.get(r.nextInt(0, lista.size()));
    }
}
