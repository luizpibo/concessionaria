package com.concessionaria.DTOs;

import com.concessionaria.entities.AutomovelModel;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class PedidoDTO {
    @NonNull
    private UUID funcionario_id;
    @NonNull
    private UUID cliente_id;
    @NonNull
    private  String description;
    @NonNull
    private AutomovelModel automovel;
    @NonNull
    private int daysForDelivery;
}
