package com.wdmcell.TecSystem.Repository;

import com.wdmcell.TecSystem.DTO.EstoqueDTO;
import com.wdmcell.TecSystem.DTO.MarcaDTO;
import com.wdmcell.TecSystem.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto , Long> {
    @Query("SELECT new com.wdmcell.TecSystem.DTO.EstoqueDTO(p.modelo, p.estoque) FROM Produto p")
    List<EstoqueDTO> listarEstoque();

    @Query("SELECT new com.wdmcell.TecSystem.DTO.MarcaDTO(p.marca) FROM Produto p")
    List<MarcaDTO> listarMarcas();

    @Modifying
    @Query("UPDATE Produto p SET p.estoque = p.estoque - :quantidade " +
            "WHERE p.id = :id AND p.estoque >= :quantidade")
    int diminuirEstoque(@Param("id") Long id, @Param("quantidade") Integer quantidade);
}
