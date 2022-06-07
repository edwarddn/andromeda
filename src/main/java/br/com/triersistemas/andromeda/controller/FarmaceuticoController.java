package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Contato;
import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.model.ContatoModel;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    private static final List<Farmaceutico> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public List<Farmaceutico> cadastrar(@RequestBody FarmaceuticoModel model) {
        LIST.add(new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf()));
        return LIST;
    }

    @PostMapping("/cadastrar-random")
    public List<Farmaceutico> cadastrarRandom() {
        LIST.add(new Farmaceutico());
        return LIST;
    }

    @PutMapping("/alterar/{index}")
    public List<Farmaceutico> alterar(@PathVariable int index, @RequestBody FarmaceuticoModel model) {
        LIST.remove(index);
        LIST.add(new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf()));
        return LIST;
    }

    @DeleteMapping("/remover/{index}")
    public List<Farmaceutico> remover(@PathVariable int index) {
        LIST.remove(index);
        return LIST;
    }
}
