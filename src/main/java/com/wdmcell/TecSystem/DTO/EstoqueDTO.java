package com.wdmcell.TecSystem.DTO;

public class EstoqueDTO {
    private String modelo;
    private int estoque;

    public EstoqueDTO() {
    }

    public EstoqueDTO(String modelo, int estoque) {
        this.modelo = modelo;
        this.estoque = estoque;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }   
}

