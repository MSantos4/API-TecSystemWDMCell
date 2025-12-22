package com.wdmcell.TecSystem.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {
    @NotBlank(message = "Marca é obrigatório")
    private String marca;
    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;
    @Positive(message = "O preço de compra deve sair maior que 0")
    private Double preco_compra;
    @Positive(message = "O preço de venda deve sair maior que 0")
    private Double preco_venda;
    @Positive(message = "O produto precisa ter estoque para ser cadastrado")
    private int estoque;
    @NotBlank(message = "Tipo de tela é obrigatório")
    private String tela;
    @NotBlank(message = "Processador é obrigatório")
    private String processador;
    @NotBlank(message = "Tamanho de armazenamento é obrigatório")
    private String armazenamento;
    @NotBlank(message = "Memória RAM é obrigatório")
    private String memoria;
    @NotBlank(message = "Quantidade de bateria é obrigatório")
    private String bateria;
    @NotBlank(message = "Sistema e versão são obrigatórios")
    private String sistema;
    @Positive(message = "A espessura deve sair maior que 0")
    private Double espessura;
    @Positive(message = "O Peso deve sair maior que 0")
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public void setEspessura(Double espessura) {
        this.espessura = espessura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
