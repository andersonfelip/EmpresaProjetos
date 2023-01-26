package com.empresaprojetos.portfolio.repository;

import com.empresaprojetos.portfolio.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>, JpaRepository<Pessoa, Long> {

    List<Pessoa> findPessoaByFuncionario(Boolean funcionario);
}
