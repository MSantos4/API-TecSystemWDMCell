package com.wdmcell.TecSystem.DTO.Response;

public class VendaResponse {
    private Long id;
    private String cliente;
    private int quantidadeItens;
    private Double valorTotal;

    public VendaResponse(Long id, String cliente, int quantidadeItens, Double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
    }
}
