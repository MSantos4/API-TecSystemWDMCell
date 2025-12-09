package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String matricula;
    private String cpf;
    
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Login login;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    List<Pedido> pedidos;
}
