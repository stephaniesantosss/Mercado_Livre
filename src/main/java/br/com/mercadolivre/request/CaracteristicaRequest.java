package br.com.mercadolivre.request;

import br.com.mercadolivre.model.CaracteristicaProduto;
import br.com.mercadolivre.model.Produto;

import javax.validation.constraints.NotBlank;

public class CaracteristicaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public CaracteristicaRequest() {
    }

    public CaracteristicaRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public CaracteristicaProduto toConverter(Produto produto) {
        return new CaracteristicaProduto(nome, descricao, produto);
    }
}
