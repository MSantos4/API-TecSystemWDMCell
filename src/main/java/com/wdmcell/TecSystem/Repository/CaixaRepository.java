package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse;
import com.wdmcell.TecSystem.Model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
    @Query("SELECT new com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse(p.marcaProduto,\n" +
            "        p.modeloProduto,\n" +
            "        ip.quantidade,\n" +
            "        c.valor * ip.quantidade) FROM Produto p JOIN p.itensPedido ip JOIN ip.caixa c")
    UltimaVendaResponse ultimaVenda();
}
