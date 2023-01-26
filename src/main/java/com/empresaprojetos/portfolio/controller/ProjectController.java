package com.empresaprojetos.portfolio.controller;

import com.empresaprojetos.portfolio.constants.Configuration;
import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.dto.ProjetoDto;
import com.empresaprojetos.portfolio.mapper.ProjetoSourceProjetoDtoMapper;
import com.empresaprojetos.portfolio.service.ProjetoService;
import jakarta.servlet.http.HttpServletRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.empresaprojetos.portfolio.constants.Constants.*;


@Controller
public class ProjectController {
    private Configuration configuration;
    private final ProjetoService projetoService;

    private final ProjetoSourceProjetoDtoMapper mapper
            = Mappers.getMapper(ProjetoSourceProjetoDtoMapper.class);

    @Autowired
    public ProjectController(Configuration configuration, ProjetoService projetoService) {
        this.configuration = configuration;
        this.projetoService = projetoService;
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest httpServletRequest) {

        Pageable pageable = PageRequest.of(configuration.getPageNumber(), configuration.getPageSize());
        Page<Projeto> page = projetoService.findAll(pageable);

        List<ProjetoDto> listProjects = mapper.map(page.getContent());

        model.addAttribute(CURRENT_PAGE, configuration.getPageNumber());
        model.addAttribute(TOTAL_PAGES, page.getTotalPages());
        model.addAttribute(TOTAL_ITEMS, page.getTotalElements());
        model.addAttribute(LIST, listProjects);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model, HttpServletRequest httpServletRequest) {
        return "create";
    }
}

