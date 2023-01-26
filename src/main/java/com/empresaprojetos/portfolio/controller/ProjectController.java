package com.empresaprojetos.portfolio.controller;

import com.empresaprojetos.portfolio.constants.Configuration;
import com.empresaprojetos.portfolio.domain.Pessoa;
import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.dto.PessoaDto;
import com.empresaprojetos.portfolio.dto.ProjetoDto;
import com.empresaprojetos.portfolio.mapper.PessoaSourcePessoaDtoMapper;
import com.empresaprojetos.portfolio.mapper.ProjetoSourceProjetoDtoMapper;
import com.empresaprojetos.portfolio.service.PessoaService;
import com.empresaprojetos.portfolio.service.ProjetoService;
import jakarta.servlet.http.HttpServletRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.empresaprojetos.portfolio.constants.Constants.*;


@Controller
public class ProjectController {
    private final Configuration configuration;
    private final ProjetoService projetoService;

    private final PessoaService pessoaService;

    private final ProjetoSourceProjetoDtoMapper mapperProjeto
            = Mappers.getMapper(ProjetoSourceProjetoDtoMapper.class);

    private final PessoaSourcePessoaDtoMapper mapperPessoa
            = Mappers.getMapper(PessoaSourcePessoaDtoMapper.class);

    @Autowired
    public ProjectController(Configuration configuration, ProjetoService projetoService,PessoaService pessoaService) {
        this.configuration = configuration;
        this.projetoService = projetoService;
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest httpServletRequest) {
        Pageable pageable = PageRequest.of(configuration.getPageNumber(), configuration.getPageSize());
        Page<Projeto> page = projetoService.findAll(pageable);
        List<ProjetoDto> listProjects = mapperProjeto.map(page.getContent());

        model.addAttribute(CURRENT_PAGE, configuration.getPageNumber());
        model.addAttribute(TOTAL_PAGES, page.getTotalPages());
        model.addAttribute(TOTAL_ITEMS, page.getTotalElements());
        model.addAttribute(LIST_PROJECTS, listProjects);
        return "index";
    }

    @GetMapping("/project")
    public String getCreate(Model model, HttpServletRequest httpServletRequest) {
        model.addAttribute("project", new ProjetoDto());
        List<Pessoa> employeesDomain = pessoaService.findPessoaByFuncionario(Boolean.TRUE);
        List<PessoaDto> employees = mapperPessoa.map(employeesDomain);
        model.addAttribute(LIST_EMPLOYEE, employees);
        return "create";
    }

    @PostMapping("/project")
    public ModelAndView  create(@ModelAttribute("project") ProjetoDto projetoDto, ModelMap model, HttpServletRequest httpServletRequest) {
        Projeto projeto = mapperProjeto.map(projetoDto);
        projetoService.create(projeto);
        return new ModelAndView("redirect:/?created=true", model);
    }
}

