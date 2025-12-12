package com.wdmcell.TecSystem.Service;

import com.wdmcell.TecSystem.DTO.LoginDTO;
import com.wdmcell.TecSystem.DTO.LoginResponseDTO;
import com.wdmcell.TecSystem.Model.Funcionario;
import com.wdmcell.TecSystem.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
   private final  FuncionarioRepository funcionarioRepository;

   public LoginResponseDTO login(LoginDTO loginDTO) {
       Funcionario funcionario = funcionarioRepository.findByUsuarioESenha(loginDTO.getUsuario(), loginDTO.getSenha());

       if (funcionario != null) {
           return new LoginResponseDTO(
                   funcionario.getId(),
                   funcionario.getNome(),
                   funcionario.getLogin().getNivel_permissao(),
                   funcionario.getMatricula()
                   );
       }
    return null;
   }

}
