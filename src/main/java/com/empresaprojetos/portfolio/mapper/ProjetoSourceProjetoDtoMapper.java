package com.empresaprojetos.portfolio.mapper;

import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.dto.ProjetoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProjetoSourceProjetoDtoMapper {
    Projeto map(ProjetoDto projetoDto);
    ProjetoDto map(Projeto projeto);

    List<ProjetoDto> map(List<Projeto> projetos);
}
