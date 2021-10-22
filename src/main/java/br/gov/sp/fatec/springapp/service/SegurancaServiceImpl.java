package br.gov.sp.fatec.springapp.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapp.entity.Categoria;
import br.gov.sp.fatec.springapp.entity.Produto;
import br.gov.sp.fatec.springapp.repository.CategoriaRepository;
import br.gov.sp.fatec.springapp.repository.ProdutoRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    ProdutoRepository produtoRepo;

    @Autowired
    CategoriaRepository categoriaRepo;

    @Transactional
    public Produto novoProduto(String nome, Integer peso, String descricao, String categoria) {
        Categoria cat = categoriaRepo.findByNome(categoria);
        if (cat == null) {
            cat = new Categoria();
            cat.setNome(categoria);
            categoriaRepo.save(cat);
        }
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPeso(peso);
        produto.setDescricao(descricao);
        produto.setCategorias(new HashSet<Categoria>());
        produto.getCategorias().add(cat);
        produtoRepo.save(produto);

        return produto;
    }

    public List<Produto> buscarTodosProdutos() {

        return produtoRepo.findAll();

    }
}
