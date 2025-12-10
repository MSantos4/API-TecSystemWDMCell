package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marca;
    private String modelo;
    private Double preco_compra;
    private Double preco_venda;
    private int estoque;
    
    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private Especificacao especificacao;

    public Produto(String marca, String modelo, Double precoCompra, Double precoVenda, int estoque, Especificacao especificacao) {
    }
}
