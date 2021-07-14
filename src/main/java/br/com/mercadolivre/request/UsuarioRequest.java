package br.com.mercadolivre.request;

import br.com.mercadolivre.model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank
    @Email
    private String login;
    @NotBlank
    @Size(min = 6)
    private String senha;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toModel(PasswordEncoder encoder) {
        String senhaUsuario = encoder.encode(senha);
        return new Usuario(login, senhaUsuario);
    }
}
