package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    List<Pedido> pegarTodosDoPote();
    Optional<Pedido> pegarDoPote(UUID id);
    void enfiarNoPote(Pedido pedido);
    void jogarParaForaDoPote(Pedido pedido);
}
