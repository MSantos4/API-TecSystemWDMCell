package com.wdmcell.TecSystem.DTO;

public class FuncionarioDTO {
    private String nome;
    private String matricula;
    private String cpf;
    private String usuario;
    private String senha;
    private String nivel_permissao;

    public FuncionarioDTO(String nome, String matricula, String cpf, String usuario, String senha, String nivel_permissao) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel_permissao = nivel_permissao;
    }

    public FuncionarioDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNivel_permissao() {
        return nivel_permissao;
    }
}
