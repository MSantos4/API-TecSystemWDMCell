package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse;
import com.wdmcell.TecSystem.Model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
    @Query("SELECT new com.wdmcell.TecSystem.DTO.Response.UltimaVendaResponse(p.marca, p.modelo, ip.quantidade, c.valor * ip.quantidade) FROM ItemPedido ip JOIN ip.produto p JOIN ip.caixa c ORDER BY c.data_transacao DESC  LIMIT 1")
    UltimaVendaResponse ultimaVenda();
}
