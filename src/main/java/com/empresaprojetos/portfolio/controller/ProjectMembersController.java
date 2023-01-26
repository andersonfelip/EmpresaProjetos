package com.empresaprojetos.portfolio.controller;

import com.empresaprojetos.portfolio.constants.Configuration;
import com.empresaprojetos.portfolio.dto.PessoaDto;
import com.empresaprojetos.portfolio.dto.ProjetoDto;
import com.empresaprojetos.portfolio.mapper.PessoaSourcePessoaDtoMapper;
import com.empresaprojetos.portfolio.mapper.ProjetoSourceProjetoDtoMapper;
import com.empresaprojetos.portfolio.service.PessoaService;
import com.empresaprojetos.portfolio.service.ProjetoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectMembersController {

    private final ProjetoService projetoService;

    private final ProjetoSourceProjetoDtoMapper mapperProjeto
            = Mappers.getMapper(ProjetoSourceProjetoDtoMapper.class);

    private final PessoaSourcePessoaDtoMapper mapperPessoa
            = Mappers.getMapper(PessoaSourcePessoaDtoMapper.class);

    @Autowired
    public ProjectMembersController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping(value = "/project/{id}/members", produces = "application/json")
    public ProjetoDto members(@PathVariable Long id, @RequestBody List<PessoaDto> membros) {
        var projeto = projetoService.findById(id);
        var funcionarios = mapperPessoa.mapDto(membros);
        projeto.setMembros(funcionarios);
        projetoService.save(projeto);
        return mapperProjeto.map(projeto);

    }
}
