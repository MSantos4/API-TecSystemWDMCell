package com.wdmcell.TecSystem.DTO.Response;

public class ProdutoResponse {
    private Long id;
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

    public ProdutoResponse(Long id, String marca, String modelo, Double preco_compra, Double preco_venda, int estoque, String tela, String processador, String armazenamento, String memoria, String bateria, String sistema, Double espessura, Double peso) {
        this.id = id;
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
}

