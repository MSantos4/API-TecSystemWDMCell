package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.LoginDTO;
import com.wdmcell.TecSystem.DTO.LoginResponseDTO;
import com.wdmcell.TecSystem.Model.Funcionario;
import com.wdmcell.TecSystem.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginDTO loginDTO) {

        Funcionario funcionario = funcionarioRepository.findByUsuario(loginDTO.getUsuario());

        if (funcionario == null) {
            return null;
        }

        boolean senhaCorreta = passwordEncoder.matches(
                loginDTO.getSenha(),
                funcionario.getLogin().getSenha()
        );

        if (!senhaCorreta) {
            return null;
        }

        return new LoginResponseDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getLogin().getNivel_permissao(),
                funcionario.getMatricula()
        );
    }
}