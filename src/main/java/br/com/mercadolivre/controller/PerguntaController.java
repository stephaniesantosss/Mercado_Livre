package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Pergunta;
import br.com.mercadolivre.repository.PerguntaRepository;
import br.com.mercadolivre.repository.ProdutoRepository;
import br.com.mercadolivre.repository.UsuarioRepository;
import br.com.mercadolivre.request.PerguntaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @PostMapping
    public ResponseEntity salvarPergunta(@RequestBody @Valid PerguntaRequest perguntaRequest) {
        Pergunta pergunta = perguntaRequest.toModel(usuarioRepository, produtoRepository);
        perguntaRepository.save(pergunta);

        System.out.println(perguntaRequest);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
