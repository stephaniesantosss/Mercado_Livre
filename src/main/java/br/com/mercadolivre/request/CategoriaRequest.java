package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Categoria;
import br.com.mercadolivre.repository.CategoriaRepository;
import br.com.mercadolivre.utils.UniqueValue;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @Column(unique = true)
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
    private Long categoriaMae;

    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getCategoriaMae() {
        return categoriaMae;
    }

    public Categoria toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = new Categoria(nome);
        if (categoriaMae != null) {
                Categoria categoriaMaeValida = categoriaRepository.getById(categoriaMae);
                categoria.setCategoriaMae(categoriaMaeValida);
                return categoria;
        }
        return categoria;
    }
}

