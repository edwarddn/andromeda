package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class PedidoModel {
    private UUID id;
    private ClienteModel cliente;
    private FarmaceuticoModel farmaceutico;
    private List<ProdutoModel> produtos;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private LocalDateTime data;
    private LocalDateTime dataPagamento;
    private String status;

    public PedidoModel(Pedido pedido) {
        this.id = pedido.getId();

        this.cliente = Objects.nonNull(pedido.getCliente()) ?
                new ClienteModel(pedido.getCliente()) : new ClienteModel();

        this.farmaceutico = Objects.nonNull(pedido.getFarmaceutico()) ?
                new FarmaceuticoModel(pedido.getFarmaceutico()) : new FarmaceuticoModel();

        this.produtos = criaListaProduto(pedido.getProdutos());
        this.valor = pedido.getValor();
        this.valorPago = pedido.getValorPago();
        this.troco = pedido.getTroco();
        this.data = pedido.getData();
        this.dataPagamento = pedido.getDataPagamento();
        this.status = pedido.getStatus().name();
    }

    private List<ProdutoModel> criaListaProduto(List<Produto> produtos) {
        if (Objects.nonNull(produtos) && !produtos.isEmpty()) {
            return produtos.stream().map(ProdutoModel::new).toList();
        } else {
            return new ArrayList<>();
        }
    }
}
