package com.empresaprojetos.portfolio.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Max(100)
    private String nome;
    @Column(name = "datanascimento", columnDefinition = "DATE")
    private Date dataNascimento;
    @Max(14)
    private String cpf;
    private boolean funcionario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="membros",
            joinColumns={@JoinColumn(name="idprojeto")},
            inverseJoinColumns={@JoinColumn(name="idpessoa")})
    private List<Projeto> projetos;
}
