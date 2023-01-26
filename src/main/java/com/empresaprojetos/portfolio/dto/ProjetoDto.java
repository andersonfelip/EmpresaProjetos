package com.empresaprojetos.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProjetoDto {

    private long id;
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoFim;
    private Date dataFim;
    private String descricao;
    private String status;
    private Float orcamento;
    private String risco;
    private PessoaDto pessoaDto;
    private List<PessoaDto> pessoaDtos;
}
