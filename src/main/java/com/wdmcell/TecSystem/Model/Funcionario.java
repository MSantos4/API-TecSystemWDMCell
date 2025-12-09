package com.wdmcell.TecSystem.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String matricula;
    private String cpf;
    
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Login login;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    List<Pedido> pedidos;

    public Funcionario(String nome, String matricula, String cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
    }

    public Funcionario() {
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
