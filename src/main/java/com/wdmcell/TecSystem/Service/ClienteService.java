package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.ClienteDTO;
import com.wdmcell.TecSystem.DTO.Response.ClienteResponse;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Model.Cliente;
import com.wdmcell.TecSystem.Repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse salvar(ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente(
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEmail(),
                clienteDTO.getTelefone()
        );

       Cliente clienteResponse =  clienteRepository.save(cliente);

        return new ClienteResponse(
                clienteResponse.getId(),
                clienteResponse.getNome(),
                clienteResponse.getCpf(),
                clienteResponse.getTelefone(),
                clienteResponse.getEmail()
        );
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
