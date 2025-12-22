package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String usuario;
    @Column(nullable = false)
    private String senha;
    @Column(length =  10, nullable = false)
    private String nivel_permissao;
    
    @OneToOne @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Login() {
    }

    public Login(String usuario, String senha, String nivel_permissao) {
        this.usuario = usuario;
        this.senha = senha;
        this.nivel_permissao = nivel_permissao;
    }
}
