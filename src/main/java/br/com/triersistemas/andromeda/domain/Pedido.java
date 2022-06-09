package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.enums.EnumStatusPedido;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Pedido {

    private UUID id;
    private Cliente cliente;
    private Farmaceutico farmaceutico;
    private List<Produto> produtos;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private LocalDateTime data;
    private LocalDateTime dataPagamento;
    private EnumStatusPedido status;

    public Pedido(final Cliente cliente, final Farmaceutico farmaceutico) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.farmaceutico = farmaceutico;
        this.produtos = new ArrayList<>();
        this.valor = BigDecimal.ZERO;
        this.valorPago = BigDecimal.ZERO;
        this.troco = BigDecimal.ZERO;
        this.data = LocalDateTime.now();
        this.status = EnumStatusPedido.PENDENTE;
    }

    public Pedido adicionarProduto(final List<Produto> produtos) {
        if (EnumStatusPedido.PENDENTE.equals(this.status)) {
            this.produtos.addAll(produtos);
            this.valor = this.produtos.stream()
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return this;
    }

    public Pedido pagar(final BigDecimal valor) {
        if (EnumStatusPedido.PENDENTE.equals(this.status) && valor.compareTo(this.valor) >= 0) {
            this.valorPago = valor;
            this.troco = this.valorPago.subtract(this.valor);
            this.dataPagamento = LocalDateTime.now();
            this.status = EnumStatusPedido.PAGO;
        }
        return this;
    }
}
