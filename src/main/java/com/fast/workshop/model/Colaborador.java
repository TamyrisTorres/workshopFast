package com.fast.workshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idColaborador;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idAtaPresenca")
    @JsonBackReference
    private AtaPresenca ataPresenca;

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

    public AtaPresenca getAtaPresenca() {
        return ataPresenca;
    }

    public void setAtaPresenca(AtaPresenca ataPresenca) {
        this.ataPresenca = ataPresenca;
    }
}
