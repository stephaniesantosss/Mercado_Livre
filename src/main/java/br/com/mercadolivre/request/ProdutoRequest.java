package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Categoria;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.model.Usuario;
import br.com.mercadolivre.repository.CategoriaRepository;
import br.com.mercadolivre.repository.UsuarioRepository;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRequest {
    @NotBlank
    private String nome;
    @NotNull
    @DecimalMin("1.00")
    private Double valor;
    @Min(0)
    @NotNull
    private Integer qtde;
    @Size(min = 3)
    private List<CaracteristicaRequest> caracteristicas = new ArrayList<>();
    private List<ImagemRequest> fotos = new ArrayList<>();
    @NotBlank
    @Size(max = 1000)
    private String descricao;
    @NotNull
    private Long categoriaId;
    @NotNull
    private Long usuarioId;
    private LocalDateTime instanteCadastro;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, Double valor, Integer qtde, List<CaracteristicaRequest> caracteristicas,
                          List<ImagemRequest> fotos, String descricao, Long categoriaId, Long usuarioId, LocalDateTime instanteCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.qtde = qtde;
        this.caracteristicas.addAll(caracteristicas);
        this.fotos.addAll(fotos);
        this.descricao = descricao;
        this.categoriaId = categoriaId;
        this.usuarioId = usuarioId;
        this.instanteCadastro = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQtde() {
        return qtde;
    }

    public List<CaracteristicaRequest> getCaracteristicas() {
        return caracteristicas;
    }

    public List<ImagemRequest> getFotos() {
        return fotos;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public Produto toModel(CategoriaRepository categoriaRepository, UsuarioRepository usuarioRepository) {
        Categoria categoria = categoriaRepository.getById(categoriaId);
        Usuario usuario = usuarioRepository.getById(usuarioId);
        return new Produto(nome, valor, qtde, caracteristicas, descricao, categoria, usuario, instanteCadastro);
    }
}
