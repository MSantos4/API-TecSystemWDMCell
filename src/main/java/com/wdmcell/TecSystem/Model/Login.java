package com.wdmcell.TecSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String usuario;
    private String senha;
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
