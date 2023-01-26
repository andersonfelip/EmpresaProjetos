package com.empresaprojetos.portfolio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class PessoaDto {
    private long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String cpf;
    private boolean funcionario;
    private List<ProjetoDto> projetos;
}
