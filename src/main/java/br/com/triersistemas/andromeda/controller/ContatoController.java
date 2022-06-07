package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Contato;
import br.com.triersistemas.andromeda.model.ContatoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private static final List<Contato> CONTATOS = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Contato> consultar() {
        return CONTATOS;
    }

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ContatoModel model) {
        CONTATOS.add(new Contato(model.getNome()));
    }

    @PutMapping("/alterar/{index}")
    public void alterar(@PathVariable int index, @RequestBody ContatoModel model) {
        CONTATOS.remove(index);
        CONTATOS.add(new Contato(model.getNome()));
    }

    @DeleteMapping("/remover/{index}")
    public List<Contato> remover(@PathVariable int index) {
        CONTATOS.remove(index);
        return CONTATOS;
    }
}
