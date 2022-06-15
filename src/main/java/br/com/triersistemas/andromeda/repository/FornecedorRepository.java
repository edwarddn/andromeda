package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Fornecedor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FornecedorRepository {
    List<Fornecedor> pegarTodosDoPote();
    Optional<Fornecedor> pegarDoPote(UUID id);
    void enfiarNoPote(Fornecedor fornecedor);
    void jogarParaForaDoPote(Fornecedor fornecedor);
}
