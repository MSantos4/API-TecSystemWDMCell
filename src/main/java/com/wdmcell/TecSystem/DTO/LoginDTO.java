package com.wdmcell.TecSystem.DTO;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "Usuário é obrigatório")
    private String usuario;

    @NotBlank(message = "Senha é obrigatório")
    private String senha;

    public LoginDTO(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public LoginDTO() {
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
