package br.com.mercadolivre.model;

import br.com.mercadolivre.request.CaracteristicaRequest;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Size(min = 3)
    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    private Set<Caracteristica> caracteristicas = new HashSet<>();
    @NotBlank @Size(max = 1000)
    private String descricao;
    @NotNull @ManyToOne
    private Categoria categoria;
    private LocalDateTime instanteCadastro;

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, Double valor, Integer qtde, Collection<CaracteristicaRequest> caracteristicas, String descricao, Categoria categoria, LocalDateTime instanteCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.qtde = qtde;
        this.caracteristicas.addAll(caracteristicas
                .stream().map(caracteristica -> caracteristica.toConverter(this))
                .collect(Collectors.toSet()));
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

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
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
