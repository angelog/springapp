package br.gov.sp.fatec.springapp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.springapp.entity.Produto;
import br.gov.sp.fatec.springapp.entity.Usuario;

public interface SegurancaService extends UserDetailsService {

    public Produto novoProduto(String nome, Integer peso, String descricao, String categoria);

    public List<Produto> buscarTodosProdutos();

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

}
