package edu.com.pweb.newsblog.dto;

import java.util.List;
import java.util.stream.Collectors;

import edu.com.pweb.newsblog.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UsuarioIn {
    private String nome;
    private String login;
    private String password;

    public UsuarioIn(Usuario usuario) {
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.password = usuario.getPassword();
    }

    public static List<UsuarioIn> converte(List<Usuario> lista) {
        return lista.stream().map(UsuarioIn::new).collect(Collectors.toList());
    }
}
