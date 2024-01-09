package com.fast.workshop.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idColaborador;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ataPresenca_id")
    private AtaPresenca ataPresenca;

    public AtaPresenca getAtasPresenca() {
        return ataPresenca;
    }

    public void setAtasPresenca(AtaPresenca ataPresenca) {
        this.ataPresenca = ataPresenca;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
