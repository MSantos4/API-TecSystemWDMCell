package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.FuncionarioDTO;
import com.wdmcell.TecSystem.DTO.Response.FuncionarioResponse;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Response<FuncionarioResponse>> salvar(@RequestBody FuncionarioDTO funcionarioDTO) {
        try {
            FuncionarioResponse funcionarioResponse = funcionarioService.salvar(funcionarioDTO);

            Response<FuncionarioResponse> response = new Response<>(
                    "Sucesso",
                    "Funcionário cadastrado com sucesso!",
                    LocalDateTime.now(),
                    funcionarioResponse
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Response<FuncionarioResponse> response = new Response<>(
                    "Erro",
                    "Erro ao cadastrar funcionário: " + e.getMessage(),
                    LocalDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<Response<List<FuncionarioResponse>>> buscarClientes() {
        try {
            List<FuncionarioResponse> funcionarioResponse = funcionarioService.buscarFuncionarios();

            Response<List<FuncionarioResponse>> response = new Response<>(
                    "Sucesso",
                    "Funcionário encontrado com sucesso!",
                    LocalDateTime.now(),
                    funcionarioResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<FuncionarioResponse>> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<FuncionarioResponse>> buscarCliente(@PathVariable Long id) {
        try {
            FuncionarioResponse clienteResponse = funcionarioService.buscarPorId(id);

            Response<FuncionarioResponse> response = new Response<>(
                    "Sucesso",
                    "Funcionário encontrado com sucesso!",
                    LocalDateTime.now(),
                    clienteResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            Response<FuncionarioResponse> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<FuncionarioResponse>> editar(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        try {
            FuncionarioResponse  clienteEditadoResponse = funcionarioService.editar(id, funcionarioDTO);

            Response<FuncionarioResponse> response = new Response<>(
                    "Sucesso",
                    "Dados do funcionário editados com sucesso!",
                    LocalDateTime.now(),
                    clienteEditadoResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<FuncionarioResponse> response = new Response<>(
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
            funcionarioService.deletar(id);

            Response<Void> response = new Response<>(
                    "Sucesso",
                    "Funcionário deletado com sucesso!",
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
