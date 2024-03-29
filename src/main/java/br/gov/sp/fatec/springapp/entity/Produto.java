package br.gov.sp.fatec.springapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springapp.controller.View;

@Entity
@Table(name = "pro_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    @JsonView(View.ProdutoCompleto.class)
    private Long id;

    @Column(name = "pro_nome")
    @JsonView(View.ProdutoSimplificado.class)
    private String nome;

    @Column(name = "pro_peso")
    @JsonView(View.ProdutoSimplificado.class)
    private Integer peso;

    @Column(name = "pro_descricao")
    @JsonView(View.ProdutoCompleto.class)
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pca_produto_categoria", joinColumns = { @JoinColumn(name = "pro_id") }, inverseJoinColumns = {
            @JoinColumn(name = "cat_id") })
    @JsonView(View.ProdutoSimplificado.class)
    private Set<Categoria> categorias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
    private Set<Movimentacao> movimento;

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
