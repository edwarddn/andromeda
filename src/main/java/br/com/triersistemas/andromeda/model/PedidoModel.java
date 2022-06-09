package br.com.triersistemas.andromeda.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PedidoModel {
    private UUID idCliente;
    private UUID idFarmaceutico;
}
