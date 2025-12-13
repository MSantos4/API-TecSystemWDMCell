package com.wdmcell.TecSystem.DTO;

public class LoginResponseDTO {

    private Long id;
    private String nome;
    private String nivel_permissao;
    private String matricula;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(Long id, String nome, String nivel_permissao, String matricula) {
        this.id = id;
        this.nome = nome;
        this.nivel_permissao = nivel_permissao;
        this.matricula = matricula;
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

    public String getNivel_permissao() {
        return nivel_permissao;
    }

    public void setNivel_permissao(String nivel_permissao) {
        this.nivel_permissao = nivel_permissao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
