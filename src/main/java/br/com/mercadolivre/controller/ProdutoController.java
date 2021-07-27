package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;
import br.com.mercadolivre.repository.CategoriaRepository;
import br.com.mercadolivre.repository.ProdutoRepository;
import br.com.mercadolivre.repository.UsuarioRepository;
import br.com.mercadolivre.request.ImagemRequest;
import br.com.mercadolivre.request.ProdutoRequest;
import br.com.mercadolivre.request.UploaderSimulado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UploaderSimulado uploaderSimulado;

    @PostMapping
    public ResponseEntity salvarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = produtoRequest.toModel(categoriaRepository, usuarioRepository);
        produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/imagens")
    @Transactional
    public String adicionaImagens(@PathVariable("id") Long id, @Valid ImagemRequest request) {
        Usuario logado = usuarioRepository.findByLogin("Eloisa@hotmail.com").get();
        Produto produto = entityManager.find(Produto.class, id);
        if (!produto.usuarioAssociado(logado)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        Set<String> links = uploaderSimulado.enviar(request.getImagens());
        produto.associaImagem(links);
        entityManager.merge(produto);
        return produto.toString();
    }
}
