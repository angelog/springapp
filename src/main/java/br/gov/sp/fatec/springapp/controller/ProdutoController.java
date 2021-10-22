package br.gov.sp.fatec.springapp.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springapp.entity.Produto;
import br.gov.sp.fatec.springapp.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    @JsonView(View.ProdutoSimplificado.class)
    public List<Produto> bucarTodosProdutos() {
        return segurancaService.buscarTodosProdutos();
    }

    @PostMapping
    @JsonView(View.ProdutoCompleto.class)
    public Produto novoProduto(@RequestBody Produto produto) {
        return segurancaService.novoProduto(produto.getNome(), produto.getPeso(), produto.getDescricao(),
                "ROLE_PRODUTO");
    }
}
