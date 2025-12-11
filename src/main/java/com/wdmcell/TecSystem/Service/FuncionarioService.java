package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.FuncionarioDTO;
import com.wdmcell.TecSystem.DTO.Response.FuncionarioResponse;
import com.wdmcell.TecSystem.Model.Funcionario;
import com.wdmcell.TecSystem.Model.Login;
import com.wdmcell.TecSystem.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioResponse salvar(FuncionarioDTO funcionarioDTO) {
        Login login = new Login (
                funcionarioDTO.getUsuario(),
                funcionarioDTO.getSenha(),
                funcionarioDTO.getNivel_permissao()
        );

        Funcionario funcionario = new Funcionario(
                funcionarioDTO.getNome(),
                funcionarioDTO.getMatricula(),
                funcionarioDTO.getCpf()
        );

        funcionario.setLogin(login);
        login.setFuncionario(funcionario);

        funcionario.setLogin(login);

        Funcionario funcionarioCadastrado = funcionarioRepository.save(funcionario);

        return new FuncionarioResponse(
                funcionarioCadastrado.getNome(),
                funcionarioCadastrado.getMatricula(),
                funcionarioCadastrado.getCpf(),
                funcionarioCadastrado.getLogin().getUsuario(),
                funcionarioCadastrado.getLogin().getNivel_permissao()
        );
    }

    public List<FuncionarioResponse> buscarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        List<FuncionarioResponse> funcionarioResponses = new ArrayList<>();

        if (funcionarios.isEmpty()) {
            throw new RuntimeException("Funcionários não encontrados");
        } else {
            for (Funcionario funcionario : funcionarios) {
                FuncionarioResponse funcionarioResponse =  new FuncionarioResponse (
                        funcionario.getNome(),
                        funcionario.getMatricula(),
                        funcionario.getCpf(),
                        funcionario.getLogin().getUsuario(),
                        funcionario.getLogin().getNivel_permissao()
                );
                funcionarioResponses.add(funcionarioResponse);
            }
            return funcionarioResponses;
        }
    }

    public FuncionarioResponse buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return new FuncionarioResponse(
                funcionario.getNome(),
                funcionario.getMatricula(),
                funcionario.getCpf(),
                funcionario.getLogin().getUsuario(),
                funcionario.getLogin().getNivel_permissao()
        );
    }

    public FuncionarioResponse editar(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> funcionarioEditar = funcionarioRepository.findById(id);

        if (funcionarioEditar.isEmpty()) {
            throw new RuntimeException("Erro ao tentar editar dados do funcionário");
        } else  {
            Funcionario funcionario = funcionarioEditar.get();

            funcionario.setNome(funcionarioDTO.getNome());
            funcionario.setMatricula(funcionarioDTO.getMatricula());
            funcionario.setCpf(funcionarioDTO.getCpf());
            funcionario.getLogin().setUsuario(funcionarioDTO.getUsuario());
            funcionario.getLogin().setSenha(funcionarioDTO.getSenha());
            funcionario.getLogin().setNivel_permissao(funcionarioDTO.getNivel_permissao());

            Funcionario funcionarioEditado = funcionarioRepository.save(funcionario);

            return new FuncionarioResponse(
                    funcionarioEditado.getNome(),
                    funcionarioEditado.getMatricula(),
                    funcionarioEditado.getCpf(),
                    funcionarioEditado.getLogin().getUsuario(),
                    funcionarioEditado.getLogin().getNivel_permissao()
            );
        }
    }

    public void deletar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não existe");
        }
        funcionarioRepository.deleteById(id);
    }
}
