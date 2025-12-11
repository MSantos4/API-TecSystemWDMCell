package com.wdmcell.TecSystem.DTO;

public class LoginDTO {
    private String usuario;
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
