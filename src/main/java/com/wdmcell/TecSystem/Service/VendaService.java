package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.ItemPedidoDTO;
import com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse;
import com.wdmcell.TecSystem.DTO.Response.VendaResponse;
import com.wdmcell.TecSystem.DTO.VendaDTO;
import com.wdmcell.TecSystem.Model.*;
import com.wdmcell.TecSystem.Repository.CaixaRepository;
import com.wdmcell.TecSystem.Repository.ClienteRepository;
import com.wdmcell.TecSystem.Repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VendaService {

    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final CaixaRepository caixaRepository;

    public VendaResponse cadastrarVenda(VendaDTO vendaDTO) {

        Pedido pedido = new Pedido();
        pedido.setData(LocalDate.now());
        Optional<Cliente> cliente = clienteRepository.findById(vendaDTO.getPedido().getClienteId());
        cliente.ifPresent(pedido::setCliente);

        List<ItemPedido> itens = new ArrayList<>();
        double valorTotal = 0.0;

        for (ItemPedidoDTO itemDTO : vendaDTO.getPedido().getItens()) {
            Optional<Produto> produto = produtoRepository.findById(itemDTO.getProdutoId());

            if (produto.isPresent()) {
                Produto produtoCadastrar = produto.get();
                ItemPedido item = new ItemPedido();
                item.setProduto(produtoCadastrar);
                item.setQuantidade(itemDTO.getQuantidade());
                item.setPedido(pedido);
                itens.add(item);

                valorTotal += produtoCadastrar.getPreco_venda() * itemDTO.getQuantidade();
            }
        }

        pedido.setItensPedido(itens);

        Caixa caixa = new Caixa();
        caixa.setData_transacao(LocalDate.now());
        caixa.setTipo_transacao(vendaDTO.getCaixa().getTipoTransacao());

        //Aplicando desconto no valor final
        valorTotal = valorTotal - (valorTotal * (vendaDTO.getCaixa().getDesconto()/100));
        caixa.setValor(valorTotal);

        caixa.setItensDePedido(itens);
        itens.forEach(item -> item.setCaixa(caixa));

        Caixa vendaCadastrada = caixaRepository.save(caixa);

        int quantidadeIntens = 0;

        for (ItemPedido itemPedido : vendaCadastrada.getItensDePedido()) {
            quantidadeIntens = quantidadeIntens + itemPedido.getQuantidade();
        }

        return new VendaResponse(
                vendaCadastrada.getId(),
                vendaCadastrada.getItensDePedido().get(1).getPedido().getCliente().getNome(),
                quantidadeIntens,
                vendaCadastrada.getValor()
        );
    }

    public UltimaVendaResponse buscarUltimaVenda() {
        return caixaRepository.ultimaVenda();
    }
}
