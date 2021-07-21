package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Categoria;
import br.com.mercadolivre.model.Produto;
import br.com.mercadolivre.repository.CategoriaRepository;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class ProdutoRequest {
    @NotBlank
    private String nome;
    @NotNull
    @DecimalMin("1.00")
    private Double valor;
    @Min(0) @NotNull
    private Integer qtde;
    //Caracteristica
    @NotBlank @Size(max = 1000)
    private String descricao;
    @NotNull
    private Long categoriaId;
    private LocalDateTime instanteCadastro;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, Double valor, Integer qtde, String descricao, Long categoriaId, LocalDateTime instanteCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.qtde = qtde;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
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

    public String getDescricao() {
        return descricao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public Produto toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getById(categoriaId);
        return new Produto(nome, valor, qtde, descricao, categoria, instanteCadastro);
    }
}
