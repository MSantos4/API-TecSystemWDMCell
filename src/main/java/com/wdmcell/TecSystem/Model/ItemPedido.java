package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int quantidade;
    
    @ManyToOne @JoinColumn(name = "id_produto")
    private Produto produto;
    
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne @JoinColumn(name = "id_caixa")
    private Caixa caixa;

    public ItemPedido() {
    }

    public ItemPedido(int quantidade, Produto produto, Pedido pedido, Caixa caixa) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.caixa = caixa;
    }
}
