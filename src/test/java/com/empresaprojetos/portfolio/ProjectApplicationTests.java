package com.empresaprojetos.portfolio;

import com.empresaprojetos.portfolio.domain.Projeto;
import com.empresaprojetos.portfolio.repository.ProjetoRepository;
import com.empresaprojetos.portfolio.service.ProjetoService;
import com.empresaprojetos.portfolio.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private ProjetoService projectoService;

	@MockBean
	private ProjetoRepository projetoRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testFindAll() {
		Pageable pageable = PageRequest.of(0, 10);
		when(projetoRepository.findAll(pageable)).thenReturn(createPage());

		var list = projectoService.findAll(pageable);
		assertEquals(list.getContent().size(),createList().size());
	}

	private Projeto createProjects(){
		Projeto projeto = new Projeto();
		projeto.setId(1);
		projeto.setNome("teste");
		return projeto;
	}

	private Page<Projeto> createPage(){
		PageRequest pageRequest = PageRequest.of(1, 10);
		Projeto projeto = new Projeto();
		projeto.setId(1);
		projeto.setNome("teste");
		List<Projeto> lista = new ArrayList<>();
		lista.add(projeto);
		return new PageImpl<>(lista, pageRequest, lista.size());
	}

	private List<Projeto> createList(){
		Projeto projeto = new Projeto();
		projeto.setId(1);
		projeto.setNome("teste");
		List<Projeto> lista = new ArrayList<>();
		lista.add(projeto);
		return lista;
	}
}
