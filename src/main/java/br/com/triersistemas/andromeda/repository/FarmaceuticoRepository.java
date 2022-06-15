package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Farmaceutico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FarmaceuticoRepository {
    List<Farmaceutico> pegarTodosDoPote();
    Optional<Farmaceutico> pegarDoPote(UUID id);
    void enfiarNoPote(Farmaceutico farmaceutico);
    void jogarParaForaDoPote(Farmaceutico farmaceutico);
}
