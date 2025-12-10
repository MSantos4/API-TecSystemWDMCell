package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
}
