package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.AdicionarProdutoModel;
import br.com.triersistemas.andromeda.model.PagarPedidoModel;
import br.com.triersistemas.andromeda.model.PedidoModel;
import br.com.triersistemas.andromeda.repository.PedidoRepository;
import br.com.triersistemas.andromeda.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FarmaceuticoServiceImpl farmaceuticoService;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Override
    public List<PedidoModel> consultar() {
        return pedidoRepository.findAll().stream().map(PedidoModel::new).toList();
    }

    @Override
    public PedidoModel consultar(UUID id) {
        return new PedidoModel(this.buscarPedidoPorId(id));
    }

    @Override
    public PedidoModel cadastrar(PedidoModel model) {
        var cliente = clienteService.consultarCliente(model.getCliente().getId());
        var farmaceutico = farmaceuticoService.consultarFarmaceutico(model.getFarmaceutico().getId());
        var pedido = new Pedido(cliente, farmaceutico);
        return new PedidoModel(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoModel adicionarProduto(UUID id, AdicionarProdutoModel model) {
        Pedido pedido = this.buscarPedidoPorId(id);
        List<Produto> produtos = produtoService.consultarProdutos(model.getIdsProdutos());
        pedido.addProdutos(produtos);
        return new PedidoModel(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoModel pagar(UUID id, PagarPedidoModel model) {
        var pedido = this.buscarPedidoPorId(id);
        return new PedidoModel(pedido.pagar(model.getValor()));
    }

    private Pedido buscarPedidoPorId(UUID id) {
        return pedidoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
