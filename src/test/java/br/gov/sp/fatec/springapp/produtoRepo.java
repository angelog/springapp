package br.gov.sp.fatec.springapp;

import br.gov.sp.fatec.springapp.entity.Produto;


public interface produtoRepo {

    static void save(Produto produto) {
    }

    static Object findByNome(String string) {
        return null;
    }

    static Object findByNomeContainsOrEmailContains(String string, int i) {
        return null;
    }

    static Object findByNomeContainsOrPesoContains(String string, String string2) {
        return null;
    }

    static Object findByNomeContainsOrPesoContains(String string, Object $missing$) {
        return null;
    }

}
