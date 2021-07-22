package br.com.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String linkImagem;
    @NotNull
    @ManyToOne
    private Produto produto;

    @Deprecated
    public Imagem() {
    }

    public Imagem(String linkImagem, Produto produto) {
        this.linkImagem = linkImagem;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public String getLinkImagem() {
        return linkImagem;
    }
}
