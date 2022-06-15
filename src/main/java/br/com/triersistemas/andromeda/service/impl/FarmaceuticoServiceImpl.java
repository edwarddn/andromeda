package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import br.com.triersistemas.andromeda.repository.FarmaceuticoRepository;
import br.com.triersistemas.andromeda.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FarmaceuticoServiceImpl implements FarmaceuticoService {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @Override
    public List<Farmaceutico> consultar() {
        return farmaceuticoRepository.pegarTodosDoPote();
    }

    @Override
    public Farmaceutico consultar(UUID id) {
        return farmaceuticoRepository.pegarDoPote(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Farmaceutico cadastrarRandom() {
        Farmaceutico farmaceutico = new Farmaceutico();
        farmaceuticoRepository.enfiarNoPote(farmaceutico);
        return farmaceutico;
    }

    @Override
    public Farmaceutico cadastrar(FarmaceuticoModel model) {
        Farmaceutico farmaceutico = new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf());
        farmaceuticoRepository.enfiarNoPote(farmaceutico);
        return farmaceutico;
    }

    @Override
    public Farmaceutico alterar(UUID id, FarmaceuticoModel model) {
        Farmaceutico farmaceutico = this.consultar(id);
        farmaceutico.editar(model.getNome(), model.getNiver(), model.getCpf());
        return farmaceutico;
    }

    @Override
    public Farmaceutico remover(UUID id) {
        Farmaceutico farmaceutico = this.consultar(id);
        farmaceuticoRepository.jogarParaForaDoPote(farmaceutico);
        return farmaceutico;
    }
}
