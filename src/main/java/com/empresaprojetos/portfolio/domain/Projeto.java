package com.empresaprojetos.portfolio.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Max(200)
    private String nome;
    @Column(name = "data_inicio", columnDefinition = "DATE")
    private Date dataInicio;
    @Column(name = "data_previsao_fim", columnDefinition = "DATE")
    private Date dataPrevisaoFim;
    @Column(name = "data_fim", columnDefinition = "DATE")
    private Date dataFim;
    @Max(5000)
    private String descricao;
    @Max(45)
    private String status;
    private Float orcamento;
    @Max(45)
    private String risco;
    @OneToOne(targetEntity=Pessoa.class, fetch=FetchType.EAGER)
    @JoinColumn(name="idgerente")
    private Pessoa gerente;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="membros",
            joinColumns={@JoinColumn(name="idpessoa")},
            inverseJoinColumns={@JoinColumn(name="idprojeto")})
    private List<Pessoa> membros;
}
