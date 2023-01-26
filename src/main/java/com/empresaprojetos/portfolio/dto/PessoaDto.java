package com.empresaprojetos.portfolio.dto;

import java.util.Date;
import java.util.List;

public class PessoaDto {
    private long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private boolean funcionario;
    private List<ProjetoDto> projetos;
}
