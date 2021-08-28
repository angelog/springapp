package br.gov.sp.fatec.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}
