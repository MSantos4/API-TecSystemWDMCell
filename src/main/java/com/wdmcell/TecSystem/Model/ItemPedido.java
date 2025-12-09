package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
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
    
    @ManyToOne @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne @JoinColumn(name = "id_caixa")
    private Caixa caixa;
}
