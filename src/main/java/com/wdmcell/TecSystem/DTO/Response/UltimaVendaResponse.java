package com.wdmcell.TecSystem.DTO.Response;

public class UltimaVendaResponse {
    private String marca;
    private String modelo;
    private int quantidade;
    private Double valor;

    public UltimaVendaResponse(String marca, String modelo, int quantidade, Double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
