package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.model.FornecedorModel;
import br.com.triersistemas.andromeda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/consultar")
    public List<Fornecedor> consultar() {
        return fornecedorService.consultar();
    }

    @PostMapping("/cadastrar")
    public Fornecedor cadastrar(@RequestBody FornecedorModel model) {
        return fornecedorService.cadastrar(model);
    }

    @PostMapping("/cadastrar-random")
    public Fornecedor cadastrarRandom() {
        return fornecedorService.cadastrarRandom();
    }

    @PutMapping("/alterar/{id}")
    public Fornecedor alterar(@PathVariable UUID id, @RequestBody FornecedorModel model) {
        return fornecedorService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Fornecedor remover(@PathVariable UUID id) {
        return fornecedorService.remover(id);
    }
}
