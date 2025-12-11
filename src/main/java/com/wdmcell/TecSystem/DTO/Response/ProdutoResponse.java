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

    public ProdutoResponse() {
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
}

