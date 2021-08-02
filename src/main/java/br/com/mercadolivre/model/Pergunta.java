package br.com.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String pergunta;
    private LocalDateTime instanteCriacao;
    @NotNull
    @ManyToOne
    private Usuario usuario;
    @NotNull
    @ManyToOne
    private Produto produto;

    @Deprecated
    public Pergunta() {
    }

    public Pergunta(String titulo, String pergunta, LocalDateTime instanteCriacao, Usuario usuarioId, Produto produtoId) {
        this.titulo = titulo;
        this.pergunta = pergunta;
        this.instanteCriacao = LocalDateTime.now();
        this.usuario = usuarioId;
        this.produto = produtoId;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPergunta() {
        return pergunta;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public Usuario getUsuarioId() {
        return usuario;
    }

    public Produto getProdutoId() {
        return produto;
    }
}
