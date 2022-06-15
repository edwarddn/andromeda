package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<Produto> consultar();
    Produto consultar(UUID id);
    List<Produto> consultar(List<UUID> ids);
    Produto cadastrar(ProdutoModel model);
    Produto alterar(UUID id, ProdutoModel model);
    Produto remover(UUID id);
}
