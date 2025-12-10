package com.wdmcell.TecSystem.DTO.Response;

public class FuncionarioResponse {
    private String nome;
    private String matricula;
    private String cpf;
    private String usuario;
    private String nivel_permissao;

    public FuncionarioResponse(String nome, String matricula, String cpf, String usuario, String nivel_permissao) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.usuario = usuario;
        this.nivel_permissao = nivel_permissao;
    }
}
