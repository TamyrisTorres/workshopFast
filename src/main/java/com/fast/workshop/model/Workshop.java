package com.fast.workshop.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idWorkshop;
    private String nome;
    private LocalDate dataRealizacao;
    private String descricao;

    @OneToOne(mappedBy = "workshop")
    private AtaPresenca ataPresenca;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

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
