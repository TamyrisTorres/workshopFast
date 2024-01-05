package com.fast.workshop.model;


import javax.persistence.*;

@Entity
public class AtaPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAta;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
