package com.fast.workshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idColaborador;
    private String nome;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<AtaPresenca> atasPresenca;

    public List<AtaPresenca> getAtasPresenca() {
        return atasPresenca;
    }

    public void setAtasPresenca(List<AtaPresenca> atasPresenca) {
        this.atasPresenca = atasPresenca;
    }

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Workshop> workshops;

    public List<Workshop> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<Workshop> workshops) {
        this.workshops = workshops;
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
