package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Categoria;
import br.com.mercadolivre.repository.CategoriaRepository;
import br.com.mercadolivre.request.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity salvarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel(categoriaRepository);
        if (categoria.getCategoriaMae() != null) {
            boolean maeCategoria = categoriaRepository.existsById(categoriaRequest.getCategoriaMae());
            if (maeCategoria) {
                categoriaRepository.save(categoria);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id da Categoria mãe não existe !");

    }
}
