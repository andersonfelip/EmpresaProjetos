package com.empresaprojetos.portfolio.mapper;

import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.dto.ProjetoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProjetoSourceProjetoDtoMapper {
    @Mapping(target="gerente.id", source="pessoaDto.id")
    Projeto map(ProjetoDto projetoDto);
    @Mapping(target="pessoaDto.nome", source="gerente.nome")
    ProjetoDto map(Projeto projeto);

    List<ProjetoDto> map(List<Projeto> projetos);
}
