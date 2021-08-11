package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Opiniao;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;

import javax.validation.constraints.*;

public class OpiniaoRequest {

    @NotNull
    @Min(1) @Max(5)
    private Integer nota;
    @NotBlank
    private String titulo;
    @NotBlank @Size(max = 500)
    private String descricao;

    public OpiniaoRequest(Integer nota, String pergunta, String descricao) {
        this.nota = nota;
        this.titulo = pergunta;
        this.descricao = descricao;
    }

    public Opiniao converter(Usuario usuario, Produto produto){
        return new Opiniao(nota, titulo, descricao, usuario, produto);
    }
}
