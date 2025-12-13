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

    public VendaResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
