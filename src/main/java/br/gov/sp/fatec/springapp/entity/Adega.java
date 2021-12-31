package br.gov.sp.fatec.springapp.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springapp.controller.View;

public class Adega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_cod")
    @JsonView(View.ProdutoCompleto.class)
    private Long id;

    @Column(name = "ad_produto")
    @JsonView(View.ProdutoSimplificado.class)
    private String nome;

    @Column(name = "ad_quantidade")
    @JsonView(View.ProdutoSimplificado.class)
    private Integer quantidade;
    
    @Column(name = "ad_marca")
    @JsonView(View.ProdutoCompleto.class)
    private String marca;

    @Column(name = "ad_local")
    @JsonView(View.ProdutoCompleto.class)
    private String local;

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}