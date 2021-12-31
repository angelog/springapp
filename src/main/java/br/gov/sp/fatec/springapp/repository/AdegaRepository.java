package br.gov.sp.fatec.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.springapp.entity.Adega;

public interface AdegaRepository extends JpaRepository<Adega,Long>{
    public Adega findByNome(String nome);

    public List<Adega> findByNomeContainsOrQuantidadeContains(String nome, String marca);

    public List<Adega> findByMarcaNome(String nome);

    public List<Adega> findByLocalSentido(String sentido);
    
}