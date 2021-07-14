package br.com.mercadolivre.controller;

import br.com.mercadolivre.model.Usuario;
import br.com.mercadolivre.repository.UsuarioRepository;
import br.com.mercadolivre.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioRequest.toModel(passwordEncoder);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
