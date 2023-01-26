package com.empresaprojetos.portfolio.service.impl;

import com.empresaprojetos.portfolio.domain.Pessoa;
import com.empresaprojetos.portfolio.repository.PessoaRepository;
import com.empresaprojetos.portfolio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Page<Pessoa> findAll(Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Pessoa create(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> findPessoaByFuncionario(Boolean funcionario){
        return pessoaRepository.findPessoaByFuncionario(funcionario);
    }
}
