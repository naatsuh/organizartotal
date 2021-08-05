package com.lc.organizartotal.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Column(name = "razaosocial", nullable = false)
    private String razaoSocial;
    @Column(name = "ativoinativo", nullable = false)
    private boolean ativoInativo;
    @Column(name = "novovelho", nullable = false)
    private boolean novoVelho;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean isAtivoInativo() {
        return ativoInativo;
    }

    public void setAtivoInativo(boolean ativoInativo) {
        this.ativoInativo = ativoInativo;
    }

    public boolean isNovoVelho() {
        return novoVelho;
    }

    public void setNovoVelho(boolean novoVelho) {
        this.novoVelho = novoVelho;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }


    //**
    // Methods Customized
    // **//
    public String novoVelho() {
        if (novoVelho == true)
            return "novo";
        else
            return "velho";
    }

    public String ativoInativo() {
        if (ativoInativo == true)
            return "ativo";
        else
            return "inativo";
    }
}
