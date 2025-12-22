package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.EstoqueDTO;
import com.wdmcell.TecSystem.DTO.MarcaDTO;
import com.wdmcell.TecSystem.DTO.ProdutoDTO;
import com.wdmcell.TecSystem.DTO.Response.ProdutoResponse;
import com.wdmcell.TecSystem.Model.Especificacao;
import com.wdmcell.TecSystem.Model.Produto;
import com.wdmcell.TecSystem.Repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        produto.setEspecificacao(especificacao);
        especificacao.setProduto(produto);

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

    public List<ProdutoResponse> buscarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoResponse> responseProdutos = new ArrayList<>();

        if (produtos.isEmpty()) {
            throw new RuntimeException("Produtos não encontrados");
        } else {
            for (Produto produto : produtos) {
                ProdutoResponse produtoResponse = new ProdutoResponse(
                        produto.getId(),
                        produto.getMarca(),
                        produto.getModelo(),
                        produto.getPreco_compra(),
                        produto.getPreco_venda(),
                        produto.getEstoque(),
                        produto.getEspecificacao().getTela(),
                        produto.getEspecificacao().getProcessador(),
                        produto.getEspecificacao().getArmazenamento(),
                        produto.getEspecificacao().getMemoria(),
                        produto.getEspecificacao().getBateria(),
                        produto.getEspecificacao().getSistema(),
                        produto.getEspecificacao().getEspessura(),
                        produto.getEspecificacao().getPeso()
                );
                responseProdutos.add(produtoResponse);
            }
            return responseProdutos;
        }
    }

    public ProdutoResponse buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return new ProdutoResponse(
                produto.getId(),
                produto.getMarca(),
                produto.getModelo(),
                produto.getPreco_compra(),
                produto.getPreco_venda(),
                produto.getEstoque(),
                produto.getEspecificacao().getTela(),
                produto.getEspecificacao().getProcessador(),
                produto.getEspecificacao().getArmazenamento(),
                produto.getEspecificacao().getMemoria(),
                produto.getEspecificacao().getBateria(),
                produto.getEspecificacao().getSistema(),
                produto.getEspecificacao().getEspessura(),
                produto.getEspecificacao().getPeso()
        );
    }

    public ProdutoResponse editar(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> clienteEditar = produtoRepository.findById(id);

        if (clienteEditar.isEmpty()) {
            throw new RuntimeException("Erro ao tentar editar dados do produto");
        } else {
            Produto produtoEditar = clienteEditar.get();

            produtoEditar.setMarca(produtoDTO.getMarca());
            produtoEditar.setModelo(produtoDTO.getModelo());
            produtoEditar.setPreco_compra(produtoDTO.getPreco_compra());
            produtoEditar.setPreco_venda(produtoDTO.getPreco_venda());
            produtoEditar.setEstoque(produtoDTO.getEstoque());

            produtoEditar.getEspecificacao().setTela(produtoDTO.getTela());
            produtoEditar.getEspecificacao().setBateria(produtoDTO.getBateria());
            produtoEditar.getEspecificacao().setEspessura(produtoDTO.getEspessura());
            produtoEditar.getEspecificacao().setPeso(produtoDTO.getPeso());
            produtoEditar.getEspecificacao().setArmazenamento(produtoDTO.getArmazenamento());
            produtoEditar.getEspecificacao().setMemoria(produtoDTO.getMemoria());
            produtoEditar.getEspecificacao().setSistema(produtoDTO.getSistema());

            Produto produtoEditado = produtoRepository.save(produtoEditar);

            return new ProdutoResponse(
                    produtoEditado.getId(),
                    produtoEditado.getMarca(),
                    produtoEditado.getModelo(),
                    produtoEditado.getPreco_compra(),
                    produtoEditado.getPreco_venda(),
                    produtoEditado.getEstoque(),

                    produtoEditado.getEspecificacao().getTela(),
                    produtoEditado.getEspecificacao().getProcessador(),
                    produtoEditado.getEspecificacao().getArmazenamento(),
                    produtoEditado.getEspecificacao().getMemoria(),
                    produtoEditado.getEspecificacao().getBateria(),
                    produtoEditado.getEspecificacao().getSistema(),
                    produtoEditado.getEspecificacao().getEspessura(),
                    produtoEditado.getEspecificacao().getPeso()
            );
        }
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não existe");
        }
        produtoRepository.deleteById(id);
    }

    public  List<EstoqueDTO> buscarEstoque() {
        return produtoRepository.listarEstoque();
    }

    public List<MarcaDTO> buscarMarcas() {
        return produtoRepository.listarMarcas();
    }
}













