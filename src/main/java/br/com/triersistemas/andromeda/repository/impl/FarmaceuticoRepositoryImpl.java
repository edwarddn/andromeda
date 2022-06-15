package br.com.triersistemas.andromeda.repository.impl;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.repository.FarmaceuticoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FarmaceuticoRepositoryImpl implements FarmaceuticoRepository {

    private static final List<Farmaceutico> LIST = new ArrayList<>();

    @Override
    public List<Farmaceutico> pegarTodosDoPote() {
        return LIST;
    }

    @Override
    public Optional<Farmaceutico> pegarDoPote(UUID id) {
       return LIST.stream().filter(farmaceutico -> id.equals(farmaceutico.getId())).findFirst();
    }

    @Override
    public void enfiarNoPote(Farmaceutico farmaceutico) {
        LIST.add(farmaceutico);
    }

    @Override
    public void jogarParaForaDoPote(Farmaceutico farmaceutico) {
        LIST.remove(farmaceutico);
    }
}
