package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.FuncionarioDTO;
import com.wdmcell.TecSystem.DTO.Response.FuncionarioResponse;
import com.wdmcell.TecSystem.Model.Funcionario;
import com.wdmcell.TecSystem.Model.Login;
import com.wdmcell.TecSystem.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        Funcionario funcionarioCadastrado = funcionarioRepository.save(funcionario);

        return new FuncionarioResponse(
                funcionarioCadastrado.getNome(),
                funcionarioCadastrado.getMatricula(),
                funcionarioCadastrado.getCpf(),
                funcionarioCadastrado.getLogin().getUsuario(),
                funcionarioCadastrado.getLogin().getNivel_permissao()
        );
    }
}
