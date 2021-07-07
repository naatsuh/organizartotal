package com.lc.organizartotal.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Column(name = "razaosocial", nullable = false)
    private String razaoSocial;
    @Column(name = "ativoinativo", nullable = false)
    private boolean ativoInativo;
    @Column(name = "novovelho", nullable = false)
    private boolean novoVelho;
}
