package br.gov.sp.fatec.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByNome(String nome);

    public List<Usuario> findByNomeContainsOrEmailContains(String nome, String email);

    public List<Usuario> findByAutorizacoesNome(String nome);

}
