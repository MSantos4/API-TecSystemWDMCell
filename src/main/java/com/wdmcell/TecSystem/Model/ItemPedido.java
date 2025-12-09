package com.wdmcell.TecSystem.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    public ItemPedido(int quantidade, Produto produto, Pedido pedido, Caixa caixa) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.caixa = caixa;
    }

    public ItemPedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
}
