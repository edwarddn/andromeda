package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.AdicionarProdutoModel;
import br.com.triersistemas.andromeda.model.PagarPedidoModel;
import br.com.triersistemas.andromeda.model.PedidoModel;
import br.com.triersistemas.andromeda.service.PedidoService;
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
    private PedidoService pedidoService;

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return pedidoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody PedidoModel model) {
        return pedidoService.cadastrar(model);
    }

    @PutMapping("/adicionar-produto/{id}")
    public Pedido adicionarProduto(@PathVariable UUID id, @RequestBody AdicionarProdutoModel model) {
        return pedidoService.adicionarProduto(id, model);
    }

    @PutMapping("/pagar/{id}")
    public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
        return pedidoService.pagar(id, model);
    }
}
