package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ProdutoModel {
    private UUID id;
    private String nome;
    private BigDecimal valor;

    public ProdutoModel(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
