package br.com.triersistemas.andromeda.model;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class AdicionarProdutoModel {
    private List<UUID> idsProdutos;
}
