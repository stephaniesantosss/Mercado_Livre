package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Opiniao;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;
import br.com.mercadolivre.repository.OpiniaoRepository;
import br.com.mercadolivre.repository.ProdutoRepository;
import br.com.mercadolivre.repository.UsuarioRepository;
import br.com.mercadolivre.request.OpiniaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
public class OpiniaoController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OpiniaoRepository opiniaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    //Fazendo validação com usuario já gravado no banco
    @PostMapping("/produto/{id}/opiniao")
    public ResponseEntity salvarOpiniao(@RequestBody @Valid OpiniaoRequest request, @PathVariable Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        Usuario usuario = usuarioRepository.findByLogin("stephanieps2016@hotmail.com").get();
        if (produto != null) {
            Opiniao opiniao = request.converter(usuario, produto);
            opiniaoRepository.save(opiniao);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
