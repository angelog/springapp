package br.gov.sp.fatec.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapp.entity.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    public List<Movimentacao> findByProdutosNome(String nome);

    
}
