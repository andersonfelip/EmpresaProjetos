package com.empresaprojetos.portfolio.repository;

import com.empresaprojetos.portfolio.domain.Projeto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends PagingAndSortingRepository<Projeto, Long> {
}
