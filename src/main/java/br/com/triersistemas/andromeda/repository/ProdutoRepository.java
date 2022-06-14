package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {
    List<Produto> pegarTodosDoPote();
    Optional<Produto> pegarDoPote(UUID id);
    void enfiarNoPote(Produto produto);
    void jogarParaForaDoPote(Produto produto);
}
