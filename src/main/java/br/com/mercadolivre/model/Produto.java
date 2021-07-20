package br.com.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull @DecimalMin("1.00")
    private Double valor;
    @Min(0) @NotNull
    private Integer qtde;
    //Caracteristica
    @NotBlank @Size(max = 1000)
    private String descricao;
    @NotNull @ManyToOne
    private Categoria categoria;
    private LocalDateTime instanteCadastro;

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, Double valor, Integer qtde, String descricao, Categoria categoria, LocalDateTime instanteCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.qtde = qtde;
        this.descricao = descricao;
        this.categoria = categoria;
        this.instanteCadastro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }
}
