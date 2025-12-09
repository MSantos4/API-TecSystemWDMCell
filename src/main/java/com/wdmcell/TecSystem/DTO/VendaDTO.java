package com.wdmcell.TecSystem.DTO;

public class VendaDTO {

    private PedidoDTO pedido;
    private CaixaDTO caixa;

    public VendaDTO() {
    }

    public VendaDTO(PedidoDTO pedido, CaixaDTO caixa) {
        this.pedido = pedido;
        this.caixa = caixa;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public CaixaDTO getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaDTO caixa) {
        this.caixa = caixa;
    }
}
