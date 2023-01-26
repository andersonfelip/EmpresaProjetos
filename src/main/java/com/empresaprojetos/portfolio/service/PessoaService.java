package com.empresaprojetos.portfolio.service;

import com.empresaprojetos.portfolio.domain.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PessoaService {
    Page<Pessoa> findAll(Pageable pageable);

    @Transactional
    Pessoa create(Pessoa pessoa);

    List<Pessoa> findPessoaByFuncionario(Boolean funcionario);
}
