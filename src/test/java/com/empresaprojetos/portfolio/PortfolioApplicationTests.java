package com.empresaprojetos.portfolio;

import com.empresaprojetos.portfolio.constants.Risk;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortfolioApplicationTests {


	@Test
	void contextLoads() {
		var teste = Risk.findByName("1").name();
		System.out.println(teste);
	}
}
