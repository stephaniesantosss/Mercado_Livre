package br.com.mercadolivre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime instanteCadastro;
    @NotBlank
    @Email
    private String login;
    @NotBlank
    @Size(min = 6)
    private String senha;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.instanteCadastro = LocalDateTime.now();
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
