package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    
    @OneToMany(mappedBy = "caixa", cascade = {CascadeType.MERGE, CascadeType.ALL})
    private List<ItemPedido> itensDePedido;

    public Caixa(String tipo_transacao, Double valor, LocalDate data_transacao, List<ItemPedido> itensDePedido) {
        this.tipo_transacao = tipo_transacao;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.itensDePedido = itensDePedido;
    }

    public Caixa() {
    }
}
