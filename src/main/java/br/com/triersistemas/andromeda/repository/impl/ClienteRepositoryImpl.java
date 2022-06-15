package br.com.triersistemas.andromeda.repository.impl;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private static final List<Cliente> LIST = new ArrayList<>();

    @Override
    public List<Cliente> pegarTodosDoPote() {
        return LIST;
    }

    @Override
    public Optional<Cliente> pegarDoPote(UUID id) {
       return LIST.stream().filter(cliente -> id.equals(cliente.getId())).findFirst();
    }

    @Override
    public void enfiarNoPote(Cliente cliente) {
        LIST.add(cliente);
    }

    @Override
    public void jogarParaForaDoPote(Cliente cliente) {
        LIST.remove(cliente);
    }
}
