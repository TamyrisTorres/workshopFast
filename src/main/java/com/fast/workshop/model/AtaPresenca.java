package com.fast.workshop.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class AtaPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAta;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Colaborador> colaboradores;

    public Integer getIdAta() {
        return idAta;
    }

    public void setIdAta(Integer idAta) {
        this.idAta = idAta;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaborador(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
