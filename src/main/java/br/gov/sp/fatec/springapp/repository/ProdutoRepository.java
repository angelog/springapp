package br.gov.sp.fatec.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.springapp.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    public Produto findByNome(String nome);

    public List<Produto> findByNomeContainsOrDescricaoContains(String nome, String descricao);

    public List<Produto> findByCategoriasNome(String nome);

    public List<Produto> findByMovimentoSentido(String sentido);
    
}
