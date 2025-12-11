package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.EstoqueDTO;
import com.wdmcell.TecSystem.DTO.MarcaDTO;
import com.wdmcell.TecSystem.DTO.ProdutoDTO;
import com.wdmcell.TecSystem.DTO.Response.ClienteResponse;
import com.wdmcell.TecSystem.DTO.Response.ProdutoResponse;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Response<ProdutoResponse>> salvar(@RequestBody ProdutoDTO produtoDTO) {
        try {
            ProdutoResponse clienteResponse = produtoService.salvar(produtoDTO);

            Response<ProdutoResponse> response = new Response<>(
                    "Sucesso",
                    "Produto cadastrado com sucesso!",
                    LocalDateTime.now(),
                    clienteResponse
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Response<ProdutoResponse> response = new Response<>(
                    "Erro",
                    "Erro ao cadastrar produto: " + e.getMessage(),
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<Response<List<ProdutoResponse>>> buscarProdutos() {
        try {
            List<ProdutoResponse> produtosResponse = produtoService.buscarProdutos();

            Response<List<ProdutoResponse>> response = new Response<>(
                    "Sucesso",
                    "Produto encontrado com sucesso!",
                    LocalDateTime.now(),
                    produtosResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<ProdutoResponse>> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ProdutoResponse>> buscarProduto(@PathVariable Long id) {
        try {
            ProdutoResponse clienteResponse = produtoService.buscarPorId(id);

            Response<ProdutoResponse> response = new Response<>(
                    "Sucesso",
                    "Produto encontrado com sucesso!",
                    LocalDateTime.now(),
                    clienteResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            Response<ProdutoResponse> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/estoque")
    public ResponseEntity<Response<List<EstoqueDTO>>> listarEstoque() {
        try {
            List<EstoqueDTO> clientesResponse = produtoService.buscarEstoque();

            Response<List<EstoqueDTO>> response = new Response<>(
                    "Sucesso",
                    "Estoque encontrado",
                    LocalDateTime.now(),
                    clientesResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<EstoqueDTO>> response = new Response<>(
                    "Erro",
                   " Estoque não encontrado",
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("marcas")
    public ResponseEntity<Response<List<MarcaDTO>>> listarMarcas() {
        try {
            List<MarcaDTO> clientesResponse = produtoService.buscarMarcas();

            Response<List<MarcaDTO>> response = new Response<>(
                    "Sucesso",
                    "Marcas encontradas",
                    LocalDateTime.now(),
                    clientesResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<MarcaDTO>> response = new Response<>(
                    "Erro",
                    "Marcas não encontradas",
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Response<ProdutoResponse>> editar(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        try {
            ProdutoResponse produtoEditadoResponse = produtoService.editar(id, produtoDTO);

            Response<ProdutoResponse> response = new Response<>(
                    "Sucesso",
                    "Dados do produto editado com sucesso!",
                    LocalDateTime.now(),
                    produtoEditadoResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<ProdutoResponse> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deletar(@PathVariable Long id) {
        try {
            produtoService.deletar(id);

            Response<Void> response = new Response<>(
                    "Sucesso",
                    "Produto deletado com sucesso!",
                    LocalDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {

            Response<Void> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
