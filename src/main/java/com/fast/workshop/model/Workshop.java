package com.fast.workshop.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idWorkshop;
    private String nome;
    private LocalDate dataRealizacao;
    private String descricao;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_ataPresenca")
    private AtaPresenca ataPresenca;
    public Integer getIdWorkshop() {
        return idWorkshop;
    }

    public void setIdWorkshop(Integer idWorkshop) {
        this.idWorkshop = idWorkshop;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AtaPresenca getAtaPresenca() {
        return ataPresenca;
    }

    public void setAtaPresenca(AtaPresenca ataPresenca) {
        this.ataPresenca = ataPresenca;
    }
}
