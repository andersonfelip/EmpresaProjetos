package com.empresaprojetos.portfolio.service;

import com.empresaprojetos.portfolio.domain.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ProjetoService {
    Projeto findById(Long id);

    Page<Projeto> findAll(Pageable pageable);

    @Transactional
    Projeto save(Projeto projeto);
    @Transactional
    void delete(Long id);
}
