package com.wdmcell.TecSystem.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipo_transacao;
    private Double valor;
    private LocalDate data_transacao;
    
    @OneToMany(mappedBy = "caixa", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ItemPedido> itensDePedido;

    public Caixa(String tipo_transacao, Double valor, LocalDate data_transacao, List<ItemPedido> itensDePedido) {
        this.tipo_transacao = tipo_transacao;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.itensDePedido = itensDePedido;
    }

    public Caixa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_transacao() {
        return tipo_transacao;
    }

    public void setTipo_transacao(String tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(LocalDate data_transacao) {
        this.data_transacao = data_transacao;
    }

    public List<ItemPedido> getItensDePedido() {
        return itensDePedido;
    }

    public void setItensDePedido(List<ItemPedido> itensDePedido) {
        this.itensDePedido = itensDePedido;
    }
}
