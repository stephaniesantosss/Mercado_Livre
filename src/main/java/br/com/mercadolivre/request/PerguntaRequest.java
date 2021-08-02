package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Pergunta;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;
import br.com.mercadolivre.repository.ProdutoRepository;
import br.com.mercadolivre.repository.UsuarioRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerguntaRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String pergunta;
    private LocalDateTime instanteCriacao;
    @NotNull
    private Long usuarioId;
    @NotNull
    private Long produtoId;

    public PerguntaRequest(String titulo, String pergunta, LocalDateTime instanteCriacao, Long usuarioId, Long produtoId) {
        this.titulo = titulo;
        this.pergunta = pergunta;
        this.instanteCriacao = LocalDateTime.now();
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    @Override
    public String toString() {
        return "PerguntaRequest{" +
                "titulo='" + titulo + '\'' +
                ", pergunta='" + pergunta + '\'' +
                ", instanteCriacao=" + instanteCriacao +
                ", usuarioId=" + usuarioId +
                ", produtoId=" + produtoId +
                '}';
    }

    public Pergunta toModel(UsuarioRepository usuario, ProdutoRepository produto) {
        Usuario idUsuario = usuario.getById(usuarioId);
        Produto idProduto = produto.getById(produtoId);
        return new Pergunta(titulo, pergunta, instanteCriacao, idUsuario, idProduto);
    }
}
