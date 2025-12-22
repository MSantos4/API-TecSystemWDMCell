package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.ItemPedidoDTO;
import com.wdmcell.TecSystem.DTO.Response.ClienteResponse;
import com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse;
import com.wdmcell.TecSystem.DTO.Response.VendaResponse;
import com.wdmcell.TecSystem.DTO.VendaDTO;
import com.wdmcell.TecSystem.Model.*;
import com.wdmcell.TecSystem.Repository.CaixaRepository;
import com.wdmcell.TecSystem.Repository.ClienteRepository;
import com.wdmcell.TecSystem.Repository.FuncionarioRepository;
import com.wdmcell.TecSystem.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VendaService {

    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final CaixaRepository caixaRepository;

    @Transactional
    public VendaResponse cadastrarVenda(VendaDTO vendaDTO) {

        // Criar pedido
        Pedido pedido = new Pedido();
        pedido.setData(LocalDate.now());

        Cliente cliente = clienteRepository.findById(vendaDTO.getPedido().getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        pedido.setCliente(cliente);

        Funcionario funcionario = funcionarioRepository.findById(vendaDTO.getPedido().getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        pedido.setFuncionario(funcionario);

        // Criar caixa
        Caixa caixa = new Caixa();
        caixa.setData_transacao(LocalDate.now());
        caixa.setTipo_transacao(vendaDTO.getCaixa().getTipoTransacao());

        List<ItemPedido> itens = new ArrayList<>();
        double valorTotal = 0.0;

        for (ItemPedidoDTO itemDTO : vendaDTO.getPedido().getItens()) {

            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());

            item.setPedido(pedido);
            item.setCaixa(caixa);

            itens.add(item);

            valorTotal += produto.getPreco_venda() * itemDTO.getQuantidade();
        }

        pedido.setItensPedido(itens);
        caixa.setItensDePedido(itens);

        valorTotal = valorTotal - (valorTotal * (vendaDTO.getCaixa().getDesconto() / 100));
        caixa.setValor(valorTotal);

        Caixa vendaCadastrada = caixaRepository.save(caixa);

        int quantidadeItens = vendaCadastrada.getItensDePedido()
                .stream()
                .mapToInt(ItemPedido::getQuantidade)
                .sum();

        return new VendaResponse(
                vendaCadastrada.getId(),
                cliente.getNome(),
                quantidadeItens,
                vendaCadastrada.getValor()
        );
    }

    public List<VendaResponse> buscarVendas() {
        List<Caixa> vendas = caixaRepository.findAll();

        if (vendas.isEmpty()) {
            throw new RuntimeException("Nenhuma venda encontrada no caixa.");
        }

        return vendas.stream().map(caixa -> {
            int totalItens = caixa.getItensDePedido().stream()
                    .mapToInt(ItemPedido::getQuantidade)
                    .sum();

            String nomeCliente = "Não Identificado";

            if (!caixa.getItensDePedido().isEmpty()) {
                ItemPedido primeiroItem = caixa.getItensDePedido().get(0);
                if (primeiroItem.getPedido() != null && primeiroItem.getPedido().getCliente() != null) {
                    nomeCliente = primeiroItem.getPedido().getCliente().getNome();
                }
            }

            return new VendaResponse(
                    caixa.getId(),
                    nomeCliente,
                    totalItens,
                    caixa.getValor()
            );
        }).collect(Collectors.toList());
    }

    public UltimaVendaResponse buscarUltimaVenda() {
        return caixaRepository.ultimaVenda();
    }
}
