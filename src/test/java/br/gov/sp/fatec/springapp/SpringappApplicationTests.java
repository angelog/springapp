package br.gov.sp.fatec.springapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapp.entity.Categoria;
import br.gov.sp.fatec.springapp.entity.Produto;
import br.gov.sp.fatec.springapp.repository.CategoriaRepository;
import br.gov.sp.fatec.springapp.repository.ProdutoRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringappApplicationTests {

	@Autowired
	private ProdutoRepository produtoRepo;

	@Autowired
	private CategoriaRepository categoriaRepo;

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

	@Test
	void findByCategoriasNomeTest() {

		Categoria categorias = new Categoria();
		categorias.setNome("Teste");
		categoriaRepo.save(categorias);

		Produto produto = new Produto();
		produto.setNome("Teste");
		produto.setPeso(2);
		produto.setDescricao("Fruta");
		produto.setCategorias(new HashSet<Categoria>());
		produto.getCategorias().add(categorias);
		produtoRepo.save(produto);

		assertFalse(produtoRepo.findByCategoriasNome("Teste").isEmpty());
	}

	@Test
	void findByProdutosNomeTest() {

		Categoria categorias = new Categoria();
		categorias.setNome("Teste");
		categoriaRepo.save(categorias);

		Produto produto = new Produto();
		produto.setNome("Teste");
		produto.setPeso(2);
		produto.setDescricao("Fruta");
		produto.setCategorias(new HashSet<Categoria>());
		produto.getCategorias().add(categorias);
		produtoRepo.save(produto);

		assertFalse(categoriaRepo.findByProdutosNome("Teste").isEmpty());
	}
}



