package br.gov.sp.fatec.springapp.service;

import java.util.List;

import br.gov.sp.fatec.springapp.entity.Produto;

public interface SegurancaService {

    public Produto novoProduto(String nome, Integer peso, String descricao, String categoria);

    public List<Produto> buscarTodosProdutos();

}
