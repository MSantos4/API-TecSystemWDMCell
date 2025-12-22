package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false, length = 60)
    private String modelo;

    private Double preco_compra;
    private Double preco_venda;

    private int estoque;
    
    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private Especificacao especificacao;

    public Produto() {
    }

    public Produto(String marca, String modelo, Double preco_compra, Double preco_venda, int estoque, Especificacao especificacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.estoque = estoque;
        this.especificacao = especificacao;
    }
}
