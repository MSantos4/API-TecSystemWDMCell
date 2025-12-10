package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.ProdutoDTO;
import com.wdmcell.TecSystem.DTO.Response.ProdutoResponse;
import com.wdmcell.TecSystem.Model.Especificacao;
import com.wdmcell.TecSystem.Model.Produto;
import com.wdmcell.TecSystem.Repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponse salvar(ProdutoDTO produtoDTO) {
        Especificacao especificacao = new Especificacao (
                produtoDTO.getTela(),
                produtoDTO.getProcessador(),
                produtoDTO.getArmazenamento(),
                produtoDTO.getMemoria(),
                produtoDTO.getBateria(),
                produtoDTO.getSistema(),
                produtoDTO.getEspessura(),
                produtoDTO.getPeso()
        );

        Produto produto = new Produto (
                produtoDTO.getMarca(),
                produtoDTO.getModelo(),
                produtoDTO.getPreco_compra(),
                produtoDTO.getPreco_venda(),
                produtoDTO.getEstoque(),
                especificacao
        );

        Produto produtoCadastrado = produtoRepository.save(produto);

        return new ProdutoResponse(
                produtoCadastrado.getId(),
                produtoCadastrado.getMarca(),
                produtoCadastrado.getModelo(),
                produtoCadastrado.getPreco_compra(),
                produtoCadastrado.getPreco_venda(),
                produtoCadastrado.getEstoque(),
                produtoCadastrado.getEspecificacao().getTela(),
                produtoCadastrado.getEspecificacao().getProcessador(),
                produtoCadastrado.getEspecificacao().getArmazenamento(),
                produtoCadastrado.getEspecificacao().getMemoria(),
                produtoCadastrado.getEspecificacao().getBateria(),
                produtoCadastrado.getEspecificacao().getSistema(),
                produtoCadastrado.getEspecificacao().getEspessura(),
                produtoCadastrado.getEspecificacao().getPeso()
        );
    }
}
