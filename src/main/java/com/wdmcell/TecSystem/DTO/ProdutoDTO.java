package com.wdmcell.TecSystem.DTO;

public class ProdutoDTO {
    private String marca;
    private String modelo;
    private Double preco_compra;
    private Double preco_venda;
    private int estoque;
    private String tela;
    private String processador;
    private String armazenamento;
    private String memoria;
    private String bateria;
    private String sistema;
    private Double espessura;
    private Double peso;

    public ProdutoDTO(String marca, String modelo, Double preco_compra, Double preco_venda, int estoque, String tela, String processador, String armazenamento, String memoria, String bateria, String sistema, Double espessura, Double peso) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.estoque = estoque;
        this.tela = tela;
        this.processador = processador;
        this.armazenamento = armazenamento;
        this.memoria = memoria;
        this.bateria = bateria;
        this.sistema = sistema;
        this.espessura = espessura;
        this.peso = peso;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPreco_compra() {
        return preco_compra;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getTela() {
        return tela;
    }

    public String getProcessador() {
        return processador;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public String getMemoria() {
        return memoria;
    }

    public String getBateria() {
        return bateria;
    }

    public String getSistema() {
        return sistema;
    }

    public Double getEspessura() {
        return espessura;
    }

    public Double getPeso() {
        return peso;
    }
}
