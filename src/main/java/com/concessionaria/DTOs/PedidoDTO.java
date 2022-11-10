package com.concessionaria.DTOs;

import com.concessionaria.entities.AutomovelModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Long daysForDelivery;
}
