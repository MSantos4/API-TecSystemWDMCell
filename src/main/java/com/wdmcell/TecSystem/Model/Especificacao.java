package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Especificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tela;
    private String processador;
    private String armazenamento;
    private String memoria;
    private String bateria;
    private String sistema;
    private Double espessura;
    private Double peso;
    
    @OneToOne @JoinColumn(name = "id_produto")
    private Produto produto;

    public Especificacao() {
    }

    public Especificacao(String tela, String processador, String armazenamento, String memoria, String bateria, String sistema, Double espessura, Double peso) {
        this.tela = tela;
        this.processador = processador;
        this.armazenamento = armazenamento;
        this.memoria = memoria;
        this.bateria = bateria;
        this.sistema = sistema;
        this.espessura = espessura;
        this.peso = peso;
    }
}
