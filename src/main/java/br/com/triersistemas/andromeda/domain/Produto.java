package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.model.ProdutoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "produto")
@NoArgsConstructor
@Getter
public class Produto {

    @Id
    private UUID id;
    private String nome;
    private BigDecimal valor;

    public Produto(final String nome, final BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.editar(nome, valor);
    }

    public Produto(ProdutoModel model) {
        this.nome = model.getNome();
        this.valor = model.getValor();
    }

    public Produto editar(final String nome, final BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
        return this;
    }


}
