package com.wdmcell.TecSystem.DTO;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "matrícula é obrigatório")
    private String matricula;

    @NotBlank(message = "CPF é obrigatório") @CPF(message = "Digite um CPF válido")
    private String cpf;

    @NotBlank(message = "Usuário é obrigatório")
    private String usuario;

    @NotBlank(message = "Senha é obrigatório")
    private String senha;

    @NotBlank(message = "Nivel de permissão é obrigatório")
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNivel_permissao(String nivel_permissao) {
        this.nivel_permissao = nivel_permissao;
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
