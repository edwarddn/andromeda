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
    public List<FarmaceuticoModel> consultar() {
        return farmaceuticoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public FarmaceuticoModel consultar(@PathVariable UUID id) {
        return farmaceuticoService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public FarmaceuticoModel cadastrar(@RequestBody FarmaceuticoModel model) {
        return farmaceuticoService.cadastrar(model);
    }

    @PostMapping("/cadastrar-random")
    public FarmaceuticoModel cadastrarRandom() {
        return farmaceuticoService.cadastrarRandom();
    }

    @PutMapping("/alterar")
    public FarmaceuticoModel alterar(@RequestBody FarmaceuticoModel model) {
        return farmaceuticoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public FarmaceuticoModel remover(@PathVariable UUID id) {
        return farmaceuticoService.remover(id);
    }
}
