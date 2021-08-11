package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.request.dto.DetalheProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class DetalheProdutoController {

    @Autowired
    private EntityManager entityManager;
    @GetMapping("/produto/{id}")
    public DetalheProdutoDto detalheProduto(@PathVariable("id") Long id){
        Produto produto = entityManager.find(Produto.class, id);
        return new DetalheProdutoDto(produto);
    }
}
