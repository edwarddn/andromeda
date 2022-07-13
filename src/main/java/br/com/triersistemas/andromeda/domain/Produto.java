package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.model.ProdutoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "produto")
@NoArgsConstructor
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            insertable = false, updatable = false,
            nullable = false, unique = true)
    private UUID id;
    private String nome;
    private BigDecimal valor;

    public Produto(final String nome, final BigDecimal valor) {
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
