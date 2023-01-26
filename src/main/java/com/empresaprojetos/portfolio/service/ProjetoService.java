package com.empresaprojetos.portfolio.service;

import com.empresaprojetos.portfolio.domain.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ProjetoService {
    Page<Projeto> findAll(Pageable pageable);

    @Transactional
    Projeto create(Projeto projeto);
    @Transactional
    void delete(Long id);
}
