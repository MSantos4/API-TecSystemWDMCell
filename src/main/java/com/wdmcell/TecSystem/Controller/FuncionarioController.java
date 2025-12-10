package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.FuncionarioDTO;
import com.wdmcell.TecSystem.DTO.Response.FuncionarioResponse;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

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
}
