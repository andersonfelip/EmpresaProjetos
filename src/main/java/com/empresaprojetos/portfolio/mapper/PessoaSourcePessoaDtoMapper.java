package com.empresaprojetos.portfolio.mapper;

import com.empresaprojetos.portfolio.domain.Pessoa;
import com.empresaprojetos.portfolio.dto.PessoaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PessoaSourcePessoaDtoMapper {
    Pessoa map(PessoaDto pessoaDto);
    PessoaDto map(Pessoa pessoa);

    List<PessoaDto> map(List<Pessoa> pessoaList);

    List<Pessoa> mapDto(List<PessoaDto> pessoaDtoList);
}
