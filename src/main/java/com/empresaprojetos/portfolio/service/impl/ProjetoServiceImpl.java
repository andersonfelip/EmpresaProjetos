package com.empresaprojetos.portfolio.service.impl;

import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.repository.ProjetoRepository;
import com.empresaprojetos.portfolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoServiceImpl(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Override
    public Page<Projeto> findAll(Pageable pageable){
        return projetoRepository.findAll(pageable);
    }
}