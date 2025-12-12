package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse;
import com.wdmcell.TecSystem.DTO.Response.VendaResponse;
import com.wdmcell.TecSystem.DTO.VendaDTO;
import com.wdmcell.TecSystem.Service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("caixa ")
public class CaixaController {
    private final VendaService vendaService;

    @PostMapping
    public ResponseEntity<Response<VendaResponse>> salvar(@RequestBody  VendaDTO vendaDTO) {
        try {
            VendaResponse vendaResponse = vendaService.cadastrarVenda(vendaDTO);

            Response<VendaResponse> response = new Response<>(
                    "Sucesso",
                    "Venda realizada com sucesso!",
                    LocalDateTime.now(),
                    vendaResponse
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Response<VendaResponse> response = new Response<>(
                    "Erro",
                    "Erro ao realizar venda: " + e.getMessage(),
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<Response<UltimaVendaResponse>> buscarUltimaVenda() {
        try {
            UltimaVendaResponse ultimaVendaResponse = vendaService.buscarUltimaVenda();

            Response<UltimaVendaResponse> response = new Response<>(
                    "Sucesso",
                    "Ultima venda ocorrida",
                    LocalDateTime.now(),
                    ultimaVendaResponse
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Response<UltimaVendaResponse> response = new Response<>(
                    "Erro",
                    "Erro ao retornar ultima venda " + e.getMessage(),
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
