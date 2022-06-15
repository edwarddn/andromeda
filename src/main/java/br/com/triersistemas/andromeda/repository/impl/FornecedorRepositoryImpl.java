package br.com.triersistemas.andromeda.repository.impl;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.repository.FornecedorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FornecedorRepositoryImpl implements FornecedorRepository {

    private static final List<Fornecedor> LIST = new ArrayList<>();

    @Override
    public List<Fornecedor> pegarTodosDoPote() {
        return LIST;
    }

    @Override
    public Optional<Fornecedor> pegarDoPote(UUID id) {
       return LIST.stream().filter(fornecedor -> id.equals(fornecedor.getId())).findFirst();
    }

    @Override
    public void enfiarNoPote(Fornecedor fornecedor) {
        LIST.add(fornecedor);
    }

    @Override
    public void jogarParaForaDoPote(Fornecedor fornecedor) {
        LIST.remove(fornecedor);
    }
}
