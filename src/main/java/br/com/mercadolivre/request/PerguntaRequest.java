package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Pergunta;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PerguntaRequest {
    @NotBlank
    private String titulo;

    @JsonCreator
    public PerguntaRequest(@JsonProperty("titulo") String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "PerguntaRequest{" +
                "titulo='" + titulo + '\'' +
                '}';
    }

    public Pergunta converter(Produto produto, Usuario cliente) {
        return new Pergunta(titulo, produto, cliente);
    }
}
