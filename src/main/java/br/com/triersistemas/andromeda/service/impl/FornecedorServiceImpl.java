package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FornecedorModel;
import br.com.triersistemas.andromeda.repository.FornecedorRepository;
import br.com.triersistemas.andromeda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> consultar() {
        return fornecedorRepository.pegarTodosDoPote();
    }

    @Override
    public Fornecedor consultar(UUID id) {
        return fornecedorRepository.pegarDoPote(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Fornecedor cadastrarRandom() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedorRepository.enfiarNoPote(fornecedor);
        return fornecedor;
    }

    @Override
    public Fornecedor cadastrar(FornecedorModel model) {
        Fornecedor fornecedor = new Fornecedor(model.getNome(), model.getNiver(), model.getCnpj());
        fornecedorRepository.enfiarNoPote(fornecedor);
        return fornecedor;
    }

    @Override
    public Fornecedor alterar(UUID id, FornecedorModel model) {
        Fornecedor fornecedor = this.consultar(id);
        fornecedor.editar(model.getNome(), model.getNiver(), model.getCnpj());
        return fornecedor;
    }

    @Override
    public Fornecedor remover(UUID id) {
        Fornecedor fornecedor = this.consultar(id);
        fornecedorRepository.jogarParaForaDoPote(fornecedor);
        return fornecedor;
    }
}
