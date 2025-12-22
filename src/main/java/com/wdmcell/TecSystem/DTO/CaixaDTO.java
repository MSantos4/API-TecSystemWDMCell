package com.wdmcell.TecSystem.DTO;

public class CaixaDTO {
    private String tipoTransacao;
    private Double valor;
    private Double desconto;

    public CaixaDTO() {
    }

    public CaixaDTO(String tipoTransacao, Double valor, Double desconto) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.desconto = desconto;
    }
    
    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
