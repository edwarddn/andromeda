package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    public static final List<Farmaceutico> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Farmaceutico cadastrar(@RequestBody FarmaceuticoModel model) {
        var farmaceutico = new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf());
        LIST.add(farmaceutico);
        return farmaceutico;
    }

    @PostMapping("/cadastrar-random")
    public Farmaceutico cadastrarRandom() {
        var farmaceutico = new Farmaceutico();
        LIST.add(farmaceutico);
        return farmaceutico;
    }

    @PutMapping("/alterar/{id}")
    public Farmaceutico alterar(@PathVariable UUID id, @RequestBody FarmaceuticoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getNiver(), model.getCpf());
        return domain;
    }

    @DeleteMapping("/remover/{id}")
    public Farmaceutico remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}
