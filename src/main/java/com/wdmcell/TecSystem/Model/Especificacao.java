package com.wdmcell.TecSystem.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Especificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tela;
    private String processador;
    private String armazenamento;
    private String memoria;
    private String bateria;
    private String sistema;
    private Double espessura;
    private Double peso;
    
    @OneToOne @JoinColumn(name = "id_produto")
    private Produto produto;

    public Especificacao(String tela, String processador, String armazenamento, String memoria, String bateria, String sistema, Double espessura, Double peso) {
        this.tela = tela;
        this.processador = processador;
        this.armazenamento = armazenamento;
        this.memoria = memoria;
        this.bateria = bateria;
        this.sistema = sistema;
        this.espessura = espessura;
        this.peso = peso;
    }
    
    public Especificacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public Double getEspessura() {
        return espessura;
    }

    public void setEspessura(Double espessura) {
        this.espessura = espessura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
