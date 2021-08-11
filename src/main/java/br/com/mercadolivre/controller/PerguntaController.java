package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Pergunta;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;
import br.com.mercadolivre.repository.PerguntaRepository;
import br.com.mercadolivre.repository.ProdutoRepository;
import br.com.mercadolivre.repository.UsuarioRepository;
import br.com.mercadolivre.request.PerguntaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PerguntaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/produto/{id}/pergunta")
    @Transactional
    public ResponseEntity novaPergunta(@RequestBody @Valid PerguntaRequest request, @PathVariable("id") Long id){
        Produto produto = entityManager.find(Produto.class, id);
        Usuario cliente = usuarioRepository.findByLogin("stephanieps2016@hotmail.com").get();
        if(produto != null) {
            Pergunta pergunta = request.converter(produto, cliente);
            entityManager.persist(pergunta);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
