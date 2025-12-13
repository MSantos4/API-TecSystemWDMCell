package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nome;
    @Column(length = 10, nullable = false)
    private String matricula;
    @Column(length = 14, unique = true, nullable = false)
    private String cpf;
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Login login;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    List<Pedido> pedidos;

    public Funcionario() {
    }

    public Funcionario(String nome, String matricula, String cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
    }
}
