package com.wdmcell.TecSystem.DTO.Response;

public class FuncionarioResponse {
    private Long id;
    private String nome;
    private String matricula;
    private String cpf;
    private String usuario;
    private String nivel_permissao;

    public FuncionarioResponse(Long id, String nome, String matricula, String cpf, String usuario, String nivel_permissao) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.usuario = usuario;
        this.nivel_permissao = nivel_permissao;
    }

    public FuncionarioResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNivel_permissao() {
        return nivel_permissao;
    }

    public void setNivel_permissao(String nivel_permissao) {
        this.nivel_permissao = nivel_permissao;
    }
}
