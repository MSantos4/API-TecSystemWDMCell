package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.ClienteDTO;
import com.wdmcell.TecSystem.DTO.Response.ClienteResponse;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

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

    @GetMapping
    public ResponseEntity<Response<List<ClienteResponse>>> buscarClientes() {
        try {
            List<ClienteResponse> clientesResponse = clienteService.buscarClientes();

            Response<List<ClienteResponse>> response = new Response<>(
                    "Sucesso",
                    "Cliente encontrado com sucesso!",
                    LocalDateTime.now(),
                    clientesResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<ClienteResponse>> response = new Response<>(
                    "Erro",
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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
                    e.getMessage(),
                    LocalDateTime.now(),
                    null
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Response<ClienteResponse>> editar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteResponse  clienteEditadoResponse = clienteService.editar(id, clienteDTO);

            Response<ClienteResponse> response = new Response<>(
                    "Sucesso",
                    "Dados do cliente editados com sucesso!",
                    LocalDateTime.now(),
                    clienteEditadoResponse
            );

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<ClienteResponse> response = new Response<>(
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
                     e.getMessage(),
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
