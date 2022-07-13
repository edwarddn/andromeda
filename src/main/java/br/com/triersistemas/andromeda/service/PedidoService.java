package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.model.AdicionarProdutoModel;
import br.com.triersistemas.andromeda.model.PagarPedidoModel;
import br.com.triersistemas.andromeda.model.PedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    List<PedidoModel> consultar();
    PedidoModel consultar(UUID id);
    PedidoModel cadastrar(PedidoModel model);
    PedidoModel adicionarProduto(UUID id, AdicionarProdutoModel model);
    PedidoModel pagar(UUID id, PagarPedidoModel model);
}
