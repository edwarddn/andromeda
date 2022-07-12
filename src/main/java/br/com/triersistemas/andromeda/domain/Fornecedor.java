package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;

@Entity
@Table(name = "fornecedor")
@Getter
public class Fornecedor extends PessoaJuridica {

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(columnDefinition = "fornecedor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(columnDefinition = "produto_id", referencedColumnName = "id")
    )
    private List<Produto> produtos;

    public Fornecedor() {
        this.produtos = getProdutos();
    }

    public Fornecedor(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver, cnpj);
        this.produtos = getProdutos();
    }

    public List<Produto> getProdutos() {
        if (Objects.isNull(produtos)) {
            produtos = new ArrayList<>();
        }
        return produtos;
    }
}
