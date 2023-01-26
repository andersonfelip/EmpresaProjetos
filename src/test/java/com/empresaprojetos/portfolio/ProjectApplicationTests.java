package com.empresaprojetos.portfolio;

import com.empresaprojetos.portfolio.repository.ProjetoRepository;
import com.empresaprojetos.portfolio.service.ProjetoService;
import com.empresaprojetos.portfolio.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private ProjetoService projectoService;

	@MockBean
	private ProjetoRepository projetoRepository;

	@Test
	void testFindAll() {
		Pageable pageable = PageRequest.of(0, 10);
		var list = projectoService.findAll(pageable);
		System.out.println(list);
	}
}
