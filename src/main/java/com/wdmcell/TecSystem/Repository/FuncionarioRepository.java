package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
    @Query("SELECT f FROM Funcionario f JOIN FETCH f.login l where l.usuario  = :usuario ")
    Funcionario  findByUsuario(String usuario);
}
