package com.empresaprojetos.portfolio.service;

import com.empresaprojetos.portfolio.domain.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjetoService {
    Page<Projeto> findAll(Pageable pageable);
}
