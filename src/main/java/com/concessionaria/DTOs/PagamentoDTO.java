package com.concessionaria.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    @NonNull
    private LocalDateTime data_vencimento;
    @NonNull
    private LocalDateTime data_pagamento;
    @NonNull
    private int tipo_pagamento;
}
