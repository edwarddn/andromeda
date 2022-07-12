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
    public List<FarmaceuticoModel> consultar() {
        return farmaceuticoRepository.findAll().stream().map(FarmaceuticoModel::new).toList();
    }

    @Override
    public FarmaceuticoModel consultar(UUID id) {
        return new FarmaceuticoModel(this.buscarPorId(id));
    }

    @Override
    public FarmaceuticoModel cadastrarRandom() {
        Farmaceutico farmaceutico = new Farmaceutico();
        return new FarmaceuticoModel(farmaceuticoRepository.save(farmaceutico));
    }

    @Override
    public FarmaceuticoModel cadastrar(FarmaceuticoModel model) {
        Farmaceutico farmaceutico = new Farmaceutico(model);
        return new FarmaceuticoModel(farmaceuticoRepository.save(farmaceutico));
    }

    @Override
    public FarmaceuticoModel alterar(FarmaceuticoModel model) {
        Farmaceutico farmaceutico = this.buscarPorId(model.getId());
        farmaceutico.editar(model.getNome(), model.getNiver(), model.getCpf());
        return new FarmaceuticoModel(farmaceuticoRepository.save(farmaceutico));
    }

    @Override
    public FarmaceuticoModel remover(UUID id) {
        Farmaceutico farmaceutico = this.buscarPorId(id);
        farmaceuticoRepository.delete(farmaceutico);
        return new FarmaceuticoModel(farmaceutico);
    }

    private Farmaceutico buscarPorId(UUID id) {
        return farmaceuticoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
