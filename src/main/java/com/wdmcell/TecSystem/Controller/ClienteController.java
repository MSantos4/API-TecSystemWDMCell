package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.ClienteDTO;
import com.wdmcell.TecSystem.DTO.Response.ClienteResponse;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Response<ClienteResponse>> salvar(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteResponse clienteResponse = clienteService.salvar(clienteDTO);

            Response<ClienteResponse> response = new Response<>(
                    "Sucesso",
                    "Cliente cadastrado com sucesso!",
                    LocalDateTime.now(),
                    clienteResponse
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Response<ClienteResponse> response = new Response<>(
                    "Erro",
                    "Erro ao cadastrar cliente: " + e.getMessage(),
                    LocalDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ClienteResponse>> buscarCliente(@PathVariable Long id) {
        try {
            ClienteResponse clienteResponse = clienteService.buscarPorId(id);

            Response<ClienteResponse> response = new Response<>(
                    "Sucesso",
                    "Cliente encontrado com sucesso!",
                    LocalDateTime.now(),
                    clienteResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            Response<ClienteResponse> response = new Response<>(
                    "Erro",
                    "Cliente não encontrado: " + e.getMessage(),
                    LocalDateTime.now(),
                    null
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deletar(@PathVariable Long id) {
        try {
            clienteService.deletar(id);

            Response<Void> response = new Response<>(
                    "Sucesso",
                    "Cliente deletado com sucesso!",
                    LocalDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            Response<Void> response = new Response<>(
                    "Erro",
                    "Erro ao deletar cliente: " + e.getMessage(),
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
