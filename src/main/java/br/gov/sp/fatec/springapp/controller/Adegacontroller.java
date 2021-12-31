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

import br.gov.sp.fatec.springapp.entity.Adega;
import br.gov.sp.fatec.springapp.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/adega")
public class Adegacontroller {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    @JsonView(View.AdegaSimplificado.class)
    public List<Adega> bucarTodosPro() {
        return segurancaService.buscarTodosPro();
    }

    @PostMapping
    @JsonView(View.AdegaCompleto.class)
    public Adega novoPro(@RequestBody Adega produto) {
        return segurancaService.novoPro(produto.getNome(), produto.getQuantidade(), produto.getMarca(),
                "ROLE_PRODUTO");
    }
}
