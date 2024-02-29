package com.fast.workshop.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AtaPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAtaPresenca")
    private Integer idAta;

    private String name;

    @OneToOne(mappedBy = "ataPresenca")
    @JsonManagedReference
    private Workshop workshop;

    @OneToMany(mappedBy = "ataPresenca")
    @JsonManagedReference
    private List<Colaborador> colaboradores;

    public Integer getIdAta() {
        return idAta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
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
