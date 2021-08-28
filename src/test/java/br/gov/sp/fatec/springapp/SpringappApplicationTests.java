package br.gov.sp.fatec.springapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapp.entity.Produto;
import br.gov.sp.fatec.springapp.repository.ProdutoRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringappApplicationTests {

	@Autowired
	private ProdutoRepository produtoRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void findByNomeTest() {
		Produto produto = new Produto();
		produto.setNome("caju");
		produto.setPeso(2);
		produto.setDescricao("Fruta");
		produtoRepo.save(produto);

		assertNotNull(produtoRepo.findByNome("caju"));
	}

	@Test
	void findByNomeContainsOrDescricaoContainsTest() {

		Produto produto = new Produto();
		produto.setNome("caju");
		produto.setPeso(2);
		produto.setDescricao("Fruta");
		produtoRepo.save(produto);

		assertFalse(produtoRepo.findByNomeContainsOrDescricaoContains("caj", "lala").isEmpty());
	}
}



