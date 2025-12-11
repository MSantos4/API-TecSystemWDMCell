package com.wdmcell.TecSystem.DTO.Response;

public class UltimaVendaResponse {
    private String marca;
    private String modelo;
    private int quantidade;
    private Double valor;

    public UltimaVendaResponse(String marca, String modelo, Integer quantidade, Double valorCompra) {
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valor = valorCompra;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getValor() {
        return valor;
    }
}

