package com.concessionaria.entities;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.*;
import org.springframework.format.number.money.MonetaryAmountFormatter;

import javax.money.Monetary;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="Automovel")
public class AutomovelModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", nullable = false, length = 15)
    @NonNull
    private String nome;
    @Column(name = "marca", nullable = false, length = 15)
    @NonNull
    private String marca;
    @Column(name = "cor", nullable = false, length = 15)
    @NonNull
    private String cor;
    @Column(name = "placa", nullable = false, length = 7)
    @NonNull
    private String placa;
    @Column(name = "classi_ficacao", nullable = false, length = 15)
    @NonNull
    private String classificacao;
    @Column(name = "chassi", nullable = false, length = 15)
    @NonNull
    private String chassi;
    @Column(name = "price", nullable = false, length = 15)
    @NonNull
    private Monetary price;

}
