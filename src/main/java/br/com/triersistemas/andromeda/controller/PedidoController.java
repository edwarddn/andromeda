package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.AdicionarProdutoModel;
import br.com.triersistemas.andromeda.model.PagarPedidoModel;
import br.com.triersistemas.andromeda.model.PedidoModel;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private ProdutoService produtoService; //FIXME arrumar isso

    public static final List<Pedido> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody PedidoModel model) {

        var cliente = ClienteController.LIST.stream()
                .filter(c -> c.getId().equals(model.getIdCliente()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var farmaceutico = FarmaceuticoController.LIST.stream()
                .filter(c -> c.getId().equals(model.getIdFarmaceutico()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var pedido = new Pedido(cliente, farmaceutico);
        LIST.add(pedido);
        return pedido;
    }

    @PutMapping("/adicionar-produto/{id}")
    public Pedido adicionarProduto(@PathVariable UUID id, @RequestBody AdicionarProdutoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var produtos = model.getIdsProdutos().stream()
                .map(idProduto-> {
                    return produtoService.consultar(idProduto);
                }).collect(Collectors.toList());

        return domain.adicionarProduto(produtos);
    }

    @PutMapping("/pagar/{id}")
    public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        return domain.pagar(model.getValor());
    }
}
