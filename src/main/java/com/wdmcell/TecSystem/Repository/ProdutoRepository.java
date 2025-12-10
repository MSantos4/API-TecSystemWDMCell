package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto , Long> {

}
