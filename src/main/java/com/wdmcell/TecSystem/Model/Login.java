package com.wdmcell.TecSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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

    public Login(String usuario, String senha, String nivel_permissao) {
        this.usuario = usuario;
        this.senha = senha;
        this.nivel_permissao = nivel_permissao;
    }

    public Login() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel_permissao() {
        return nivel_permissao;
    }

    public void setNivel_permissao(String nivel_permissao) {
        this.nivel_permissao = nivel_permissao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
