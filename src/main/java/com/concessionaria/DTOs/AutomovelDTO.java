package com.concessionaria.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.money.Monetary;
import javax.persistence.Column;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelDTO {
    @NonNull
    private String nome;
    @NonNull
    private String marca;
    @NonNull
    private String cor;
    @NonNull
    private String placa;
    @NonNull
    private String classificacao;
    @NonNull
    private String chassi;
    @NonNull
    private Monetary price;
    @NonNull
    private UUID loja_id;
}
