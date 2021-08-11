package br.com.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Pergunta implements Comparable<Pergunta>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;

    private LocalDateTime instante;

    @ManyToOne()
    @NotNull
    private Produto produto;

    @ManyToOne()
    @NotNull
    private Usuario cliente;

    @Deprecated
    public Pergunta() {
    }

    public Pergunta(String titulo, Produto produto, Usuario cliente){
        this.titulo = titulo;
        this.instante = LocalDateTime.now();
        this.produto = produto;
        this.cliente = cliente;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pergunta pergunta = (Pergunta) o;

        if (id != null ? !id.equals(pergunta.id) : pergunta.id != null) return false;
        if (titulo != null ? !titulo.equals(pergunta.titulo) : pergunta.titulo != null) return false;
        if (instante != null ? !instante.equals(pergunta.instante) : pergunta.instante != null) return false;
        if (produto != null ? !produto.equals(pergunta.produto) : pergunta.produto != null) return false;
        return cliente != null ? cliente.equals(pergunta.cliente) : pergunta.cliente == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (instante != null ? instante.hashCode() : 0);
        result = 31 * result + (produto != null ? produto.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Pergunta o) {
        return this.titulo.compareTo(o.titulo);
    }
}