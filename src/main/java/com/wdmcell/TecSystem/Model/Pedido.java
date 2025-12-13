package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate data;
    
    @ManyToOne() @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    
    @ManyToOne @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido;

    public Pedido() {
    }

    public Pedido(LocalDate data, Funcionario funcionario, Cliente cliente, List<ItemPedido> itensPedido) {
        this.data = data;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.itensPedido = itensPedido;
    }
}
