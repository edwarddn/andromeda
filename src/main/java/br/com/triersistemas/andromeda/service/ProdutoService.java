package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<ProdutoModel> consultar();
    ProdutoModel consultar(UUID id);
    List<ProdutoModel> consultar(List<UUID> ids);
    ProdutoModel cadastrar(ProdutoModel model);
    ProdutoModel alterar(ProdutoModel model);
    ProdutoModel remover(UUID id);
}
