package com.wdmcell.TecSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Especificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String tela;
    @Column(length = 100)
    private String processador;
    @Column(length = 20)
    private String armazenamento;
    @Column(length = 20)
    private String memoria;
    @Column(length = 20)
    private String bateria;
    @Column(length = 50)
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
