package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

@Getter
@Entity
@Table(name = "farmaceutico")
public class Farmaceutico extends PessoaFisica {

    @Column(name = "oferta_dia")
    private String ofertaDia;

    public Farmaceutico() {
        this.ofertaDia = StringUtils.getRandomMed();
    }

    public Farmaceutico(final String nome, final LocalDate niver, final String cpf) {
        super(nome, niver, cpf);
        this.ofertaDia = StringUtils.getRandomMed();
    }

    public Farmaceutico(FarmaceuticoModel model) {
        super(model.getNome(), model.getNiver(), model.getCpf());
        this.ofertaDia = model.getOfertaDia();
    }


    public String getOfertaDia() {
        return ofertaDia;
    }
}
