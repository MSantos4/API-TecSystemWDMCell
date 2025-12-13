package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.ClienteDTO;
import com.wdmcell.TecSystem.DTO.Response.ClienteResponse;
import com.wdmcell.TecSystem.Model.Cliente;
import com.wdmcell.TecSystem.Repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Cliente clienteResponse = clienteRepository.save(cliente);

        return new ClienteResponse(
                clienteResponse.getId(),
                clienteResponse.getNome(),
                clienteResponse.getCpf(),
                clienteResponse.getTelefone(),
                clienteResponse.getEmail()
        );
    }

    public List<ClienteResponse> buscarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponse> responseClientes = new ArrayList<>();

        if (clientes.isEmpty()) {
            throw new RuntimeException("Clientes não encontrados");
        } else {
            for (Cliente cliente : clientes) {
                ClienteResponse clienteResponse = new ClienteResponse(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(),
                        cliente.getTelefone(),
                        cliente.getEmail()
                );
                responseClientes.add(clienteResponse);
            }
            return responseClientes;
        }
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

    public ClienteResponse editar(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteEditar = clienteRepository.findById(id);

        if (clienteEditar.isEmpty()) {
            throw new RuntimeException("Erro ao tentar editar dados do cliente");
        } else {
            Cliente cliente = clienteEditar.get();

            cliente.setNome(clienteDTO.getNome());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setTelefone(clienteDTO.getTelefone());
            cliente.setEmail(clienteDTO.getEmail());

            Cliente clienteEditado = clienteRepository.save(cliente);

            return new ClienteResponse(
                    clienteEditado.getId(),
                    clienteEditado.getNome(),
                    clienteEditado.getCpf(),
                    clienteEditado.getTelefone(),
                    clienteEditado.getEmail()
            );
        }
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não existe");
        }
        clienteRepository.deleteById(id);
    }
}
