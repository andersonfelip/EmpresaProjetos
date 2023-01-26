package com.empresaprojetos.portfolio.dto;

import com.empresaprojetos.portfolio.constants.Risk;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ProjetoDto {

    private long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPrevisaoFim;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;
    private String descricao;
    private String status;
    private Float orcamento;
    private String risco;
    private PessoaDto pessoaDto;
    private List<PessoaDto> pessoaDtos;
}
