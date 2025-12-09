package com.wdmcell.TecSystem.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

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

    public Produto(String marca, String modelo, Double preco_compra, Double preco_venda, int estoque, Especificacao especificacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.estoque = estoque;
        this.especificacao = especificacao;
    }
    
    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Especificacao getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(Especificacao especificacao) {
        this.especificacao = especificacao;
    }
    
    
}
