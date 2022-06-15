package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import br.com.triersistemas.andromeda.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return farmaceuticoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Farmaceutico cadastrar(@RequestBody FarmaceuticoModel model) {
        return farmaceuticoService.cadastrar(model);
    }

    @PostMapping("/cadastrar-random")
    public Farmaceutico cadastrarRandom() {
        return farmaceuticoService.cadastrarRandom();
    }

    @PutMapping("/alterar/{id}")
    public Farmaceutico alterar(@PathVariable UUID id, @RequestBody FarmaceuticoModel model) {
        return farmaceuticoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Farmaceutico remover(@PathVariable UUID id) {
        return farmaceuticoService.remover(id);
    }
}
