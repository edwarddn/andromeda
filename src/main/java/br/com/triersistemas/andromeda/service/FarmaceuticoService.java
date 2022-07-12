package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;

import java.util.List;
import java.util.UUID;

public interface FarmaceuticoService {
    List<FarmaceuticoModel> consultar();
    FarmaceuticoModel consultar(UUID id);
    FarmaceuticoModel cadastrarRandom();
    FarmaceuticoModel cadastrar(FarmaceuticoModel model);
    FarmaceuticoModel alterar(FarmaceuticoModel model);
    FarmaceuticoModel remover(UUID id);
}
