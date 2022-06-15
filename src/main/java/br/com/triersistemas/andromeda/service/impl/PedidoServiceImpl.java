package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.AdicionarProdutoModel;
import br.com.triersistemas.andromeda.model.PagarPedidoModel;
import br.com.triersistemas.andromeda.model.PedidoModel;
import br.com.triersistemas.andromeda.repository.PedidoRepository;
import br.com.triersistemas.andromeda.service.ClienteService;
import br.com.triersistemas.andromeda.service.FarmaceuticoService;
import br.com.triersistemas.andromeda.service.PedidoService;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public List<Pedido> consultar() {
        return pedidoRepository.pegarTodosDoPote();
    }

    @Override
    public Pedido consultar(UUID id) {
        return pedidoRepository.pegarDoPote(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Pedido cadastrar(PedidoModel model) {
        var cliente = clienteService.consultar(model.getIdCliente());
        var farmaceutico = farmaceuticoService.consultar(model.getIdFarmaceutico());
        var pedido = new Pedido(cliente, farmaceutico);
        pedidoRepository.enfiarNoPote(pedido);
        return pedido;
    }

    @Override
    public Pedido adicionarProduto(UUID id, AdicionarProdutoModel model) {
        Pedido pedido = this.consultar(id);
        List<Produto> produtos = produtoService.consultar(model.getIdsProdutos());
        pedido.addProdutos(produtos);
        return pedido;
    }

    @Override
    public Pedido pagar(UUID id, PagarPedidoModel model) {
        var pedido = this.consultar(id);
        return pedido.pagar(model.getValor());
    }
}
