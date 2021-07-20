package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.repository.CategoriaRepository;
import br.com.mercadolivre.repository.ProdutoRepository;
import br.com.mercadolivre.request.ProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutorController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity salvarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = produtoRequest.toModel(categoriaRepository);
        produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
