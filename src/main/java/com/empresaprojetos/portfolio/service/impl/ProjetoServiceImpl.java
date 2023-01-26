package com.empresaprojetos.portfolio.service.impl;

import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.repository.ProjetoRepository;
import com.empresaprojetos.portfolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoServiceImpl(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Override
    public Projeto findById(Long id){
        return Optional.of(projetoRepository.findById(id)).get().orElse(null);
    }

    @Override
    public Page<Projeto> findAll(Pageable pageable){
        return projetoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Projeto save(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    @Override
    @Transactional
    public void delete(Long id){
        projetoRepository.deleteById(id);
    }
}
