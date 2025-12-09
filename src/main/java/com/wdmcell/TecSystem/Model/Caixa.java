package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipo_transacao;
    private Double valor;
    private LocalDate data_transacao;
    
    @OneToMany(mappedBy = "caixa", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ItemPedido> itensDePedido;
}
