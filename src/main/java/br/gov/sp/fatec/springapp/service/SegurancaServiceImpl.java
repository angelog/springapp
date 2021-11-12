package br.gov.sp.fatec.springapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapp.entity.Autorizacao;
import br.gov.sp.fatec.springapp.entity.Categoria;
import br.gov.sp.fatec.springapp.entity.Produto;
import br.gov.sp.fatec.springapp.entity.Usuario;
import br.gov.sp.fatec.springapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springapp.repository.CategoriaRepository;
import br.gov.sp.fatec.springapp.repository.ProdutoRepository;
import br.gov.sp.fatec.springapp.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    ProdutoRepository produtoRepo;

    @Autowired
    CategoriaRepository categoriaRepo;

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

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

    @Transactional
    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao) {

        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    public List<Produto> buscarTodosProdutos() {

        return produtoRepo.findAll();

    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
                .authorities(usuario.getAutorizacoes().stream().map(Autorizacao::getNome).collect(Collectors.toList())
                        .toArray(new String[usuario.getAutorizacoes().size()]))
                .build();
    }
}
