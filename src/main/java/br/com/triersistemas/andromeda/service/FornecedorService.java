package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.model.FornecedorModel;

import java.util.List;
import java.util.UUID;

public interface FornecedorService {
    List<Fornecedor> consultar();
    Fornecedor consultar(UUID id);
    Fornecedor cadastrarRandom();
    Fornecedor cadastrar(FornecedorModel model);
    Fornecedor alterar(UUID id, FornecedorModel model);
    Fornecedor remover(UUID id);
}
