package br.com.triersistemas.andromeda.repository.impl;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.repository.ProdutoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private static final List<Produto> LIST = new ArrayList<>();

    @Override
    public List<Produto> pegarTodosDoPote() {
        return LIST;
    }

    @Override
    public Optional<Produto> pegarDoPote(UUID id) {
       return LIST.stream().filter(produto -> id.equals(produto.getId())).findFirst();
    }

    @Override
    public List<Produto> consultar(List<UUID> ids) {
        return ids.stream().map(id -> this.pegarDoPote(id).orElseThrow(NaoExisteException::new)).toList();
    }

    @Override
    public void enfiarNoPote(Produto produto) {
        LIST.add(produto);
    }

    @Override
    public void jogarParaForaDoPote(Produto produto) {
        LIST.remove(produto);
    }
}
