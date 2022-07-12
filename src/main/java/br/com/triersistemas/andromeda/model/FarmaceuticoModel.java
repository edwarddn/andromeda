package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class FarmaceuticoModel {
    private UUID id;
    private String nome;
    private LocalDate niver;
    private String cpf;
    private String ofertaDia;

    private Long idade;
    private String documento;
    private Boolean documentoValido;

    public FarmaceuticoModel(Farmaceutico farmaceutico) {
        this.id = farmaceutico.getId();
        this.nome = farmaceutico.getNome();
        this.niver = farmaceutico.getNiver();
        this.cpf = farmaceutico.getDocumento();
        this.ofertaDia = farmaceutico.getOfertaDia();
        this.idade = farmaceutico.getIdade();
        this.documento = farmaceutico.getDocumento();
        this.documentoValido = farmaceutico.getDocumentoValido();
    }
}
