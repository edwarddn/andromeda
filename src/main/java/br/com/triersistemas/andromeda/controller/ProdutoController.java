package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/consultar")
    public List<Produto> consultar() {
        return produtoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Produto alterar(@PathVariable UUID id, @RequestBody ProdutoModel model) {
        return produtoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Produto remover(@PathVariable UUID id) {
        return produtoService.remover(id);
    }
}
