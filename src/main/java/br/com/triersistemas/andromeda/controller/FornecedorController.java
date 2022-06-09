package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FornecedorModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    public static final List<Fornecedor> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Fornecedor> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Fornecedor cadastrar(@RequestBody FornecedorModel model) {
        var domain = new Fornecedor(model.getNome(), model.getNiver(), model.getCnpj());
        LIST.add(domain);
        return domain;
    }

    @PostMapping("/cadastrar-random")
    public Fornecedor cadastrarRandom() {
        var domain = new Fornecedor();
        LIST.add(domain);
        return domain;
    }

    @PutMapping("/alterar/{id}")
    public Fornecedor alterar(@PathVariable UUID id, @RequestBody FornecedorModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getNiver(), model.getCnpj());
        return domain;
    }

    @DeleteMapping("/remover/{id}")
    public Fornecedor remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}
