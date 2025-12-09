package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long> {
}
